package com.signinsystem.bo;

import com.google.gson.Gson;
import com.signinsystem.entity.Gift;

import java.io.*;
import java.util.List;

public class GiftFile {
    private File file = new File("D:\\a.doc.2\\Java\\course\\sign_in_system\\src\\main\\resources\\gift.json");
    Gson gson = new Gson();

    public Gift findGift(int id) throws IOException {
        InputStream inputStream = new FileInputStream(file);
        byte[] bGifts = new byte[(int)file.length()];
        inputStream.read(bGifts);
        String sGift = new String(bGifts);
        return gson.fromJson(sGift, Gift.class);
    }
}
