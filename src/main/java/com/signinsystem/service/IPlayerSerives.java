package com.signinsystem.service;

import com.signinsystem.service.impl.MessageDTO;
import com.signinsystem.entity.Player;

import java.io.IOException;

public interface IPlayerSerives {
    MessageDTO register(String name, String password) throws IOException;
    MessageDTO logIn(String name, String password) throws IOException;
    void signIn(Player player) throws IOException;
    void getGift(Player player) throws IOException;
}
