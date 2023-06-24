package com.signinsystem.service.impl;

import cn.hutool.core.date.DateUtil;
import com.signinsystem.bo.GiftFile;
import com.signinsystem.bo.SignInMessage;
import com.signinsystem.bo.PlayerAccount;
import com.signinsystem.entity.Player;
import com.signinsystem.service.IPlayerSerives;

import java.io.IOException;
import java.util.*;

public class PlayerSerives implements IPlayerSerives {
    private PlayerAccount playerAccount = new PlayerAccount();
    private SignInMessage signInMessage = new SignInMessage();
    private Map<String, Player> playerMap = new HashMap<>();
    private List<String> signInDate = new ArrayList<>();
    private GiftFile giftFile =new GiftFile();


    @Override
    public MessageDTO register(String name, String password) throws IOException {
        Map tempMap = playerAccount.readOut();
        if (tempMap != null) {
            playerMap = tempMap;
        }
        if (playerMap == null || !playerMap.containsKey(name)) {
            Player player = new Player(name, password);
            playerMap.put(name, player);
            playerAccount.writeIn(playerMap);
            return new MessageDTO(10000, player, "注册成功。");
        } else {
            return new MessageDTO(99999, null, "昵称已被占用，请重试。");
        }
    }

    @Override
    public MessageDTO logIn(String name, String password) throws IOException {
        playerMap = playerAccount.readOut();
        Player player = new Player(name, password);
        if (!playerMap.containsKey(name)) {
            return new MessageDTO(99999, null, "该用户不存在。");
        } else {



            if (player.equals(playerMap.get(name))) {
                return new MessageDTO(10000, player, "登录成功。");
            } else {
                return new MessageDTO(99999, null, "密码错误。");
            }
        }
    }


    @Override
    public void signIn(Player player) throws IOException {
        List<String> tempList = signInMessage.readOut();
        if (tempList != null) {
            signInDate = tempList;
        }
        String sNow = DateUtil.now().substring(0, 10);
        String yestoday = DateUtil.yesterday().toString().substring(0, 10);
        String name = player.getName();
        if (signInDate.contains(name + sNow)) {
            System.out.println("请勿重复签到。");
        } else {
            player.setDay(player.getDay() + 1);
            player.getBag().setMoney(player.getBag().getMoney() + 100);
            signInDate.add(name + sNow);
            signInMessage.writeIn(signInDate);
            System.out.println("签到成功。");
            if (!signInDate.contains(name + yestoday)) {
                player.setDay(1);
            }
            playerMap.put(player.getName(), player);
            getGift(player);
            playerAccount.writeIn(playerMap);
        }
    }

    @Override
    public void getGift(Player player) throws IOException {
        int day = player.getDay();
        if (day == 3 || day == 7 || day == 30) {
            System.out.println("你已经连续签到" + day + "天，恭喜你获得额外奖励。");
            player.getBag().getGifts().add(giftFile.findGift(day));
        }
        if (day == 30) {
            player.setDay(0);
        }
    }


    public void procedure() throws IOException {
        boolean b = true;
        MessageDTO messageDTO = null;
        Player player = null;
        System.out.println("欢迎来到签到系统。");
        a:
        while (b) {
            System.out.println("注册请按1，登录请按2：");
            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();
            System.out.print("请输入昵称：");
            String name = scanner.next();
            System.out.print("请输入密码：");
            String password = scanner.next();
            switch (choose) {
                case 1:
                    messageDTO = register(name, password);
                    if (messageDTO.getCode() == 10000) {
                        System.out.println(messageDTO.getMessage());
                        player = (Player) messageDTO.getData();
                        logIn(player.getName(), player.getPassword());
                        break;
                    } else {
                        System.out.println(messageDTO.getMessage());
                        continue a;
                    }
                case 2:
                    messageDTO = logIn(name, password);
                    if (messageDTO.getCode() == 10000) {
                        System.out.println(messageDTO.getMessage());
                        player = (Player) messageDTO.getData();
                        break;
                    } else {
                        System.out.println(messageDTO.getMessage());
                        continue a;
                    }
            }
            System.out.print("按1签到。");
            if (scanner.nextInt() == 1) {
                signIn(player);
            }

        }
    }
}
