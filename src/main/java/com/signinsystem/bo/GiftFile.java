package com.signinsystem.bo;

import com.google.gson.Gson;
import com.signinsystem.entity.Gift;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class GiftFile {
    private File file = new File("D:\\a.doc.2\\Java\\course\\sign_in_system\\src\\main\\resources\\gift.json");
    Gson gson = new Gson();

    public List<Gift> findGift(int id) throws IOException {
        MyFile myFile = new MyFile();
        List<Gift> gifts = new ArrayList<>();
        gifts = myFile.jsonToCollection(file, Gift.class);
        return gifts.stream().filter(item -> item.getiD() == id).limit(1).collect(Collectors.toList());
    }
}
