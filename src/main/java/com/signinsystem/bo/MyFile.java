package com.signinsystem.bo;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.google.gson.Gson;
import com.signinsystem.entity.Player;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyFile {
    Gson gson = new Gson();

    public void collectionToJson(List source, File file) throws IOException {
        String sFile = gson.toJson(source);
        byte[] bFile = sFile.getBytes();
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write(bFile);


    }

    public void collectionToJson(Map source, File file) throws IOException {
        String sFile = gson.toJson(source);
        byte[] bFile = sFile.getBytes();
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write(bFile);
    }

    public Map<String, Player> jsonToCollection(File file, Map<String, Player> toSource) throws IOException {
        JSONObject jsonObject = JSONUtil.readJSONObject(file, StandardCharsets.UTF_8);
        Set<String> keySet = jsonObject.keySet();
        for (String key : keySet) {
            JSONObject playerJson = jsonObject.getJSONObject(key);
            Player player = playerJson.toBean(Player.class);
            toSource.put(key, player);
        }
        return toSource;
    }

/*    public List<Gift> jsonToCollection1(File file, List<Gift> toSource) throws IOException {
        JSONArray jsonArray = JSONUtil.readJSONArray(file, StandardCharsets.UTF_8);
        for (Object object : jsonArray) {
            JSONObject playerJson = (JSONObject) object;
            Gift gift = playerJson.toBean(Gift.class);
            toSource.add(gift);
        }
        return toSource;
    }*/
    public List jsonToCollection(File file, Class cls) throws IOException {
        JSONArray jsonArray = JSONUtil.readJSONArray(file, StandardCharsets.UTF_8);
        return JSONUtil.toList(jsonArray, cls);
    }

    public void fileCreate(File file) throws IOException {
        if (!file.exists()) {
            file.createNewFile();
        }
    }

}
