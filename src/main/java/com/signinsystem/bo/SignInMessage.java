package com.signinsystem.bo;


import java.io.*;
import java.util.List;

public class SignInMessage {
    private File file = new File("D:\\a.doc.2\\Java\\course\\sign_in_system\\src\\main\\resources\\login.json");
    private MyFile myFile = new MyFile();

    public void writeIn(List<String> signInDate) throws IOException {
        myFile.fileCreate(file);
        myFile.collectionToJson(signInDate, file);
    }

    public List<String> readOut() throws IOException {
        myFile.fileCreate(file);
        return myFile.jsonToCollection(file, List.class);
    }

}
