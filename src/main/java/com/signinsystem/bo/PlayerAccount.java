package com.signinsystem.bo;

import com.signinsystem.entity.Player;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PlayerAccount {
    private Map<String, Player> playerMap = new HashMap<>();
    private File file = new File("D:\\a.doc.2\\Java\\course\\sign_in_system\\src\\main\\resources\\player.json");
    private MyFile myFile = new MyFile();

    public void writeIn(Map<String, Player> playerMap) throws IOException {
        myFile.fileCreate(file);
        myFile.collectionToJson(playerMap, file);
    }

    public Map<String, Player> readOut() throws IOException {
        myFile.fileCreate(file);
        return myFile.jsonToCollection(file, playerMap);
    }
}
