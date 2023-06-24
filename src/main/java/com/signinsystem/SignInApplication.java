package com.signinsystem;

import com.signinsystem.service.impl.PlayerSerives;
import java.io.IOException;

public class SignInApplication {
    public static void main(String[] args) throws IOException {
        PlayerSerives playerSerives = new PlayerSerives();
        playerSerives.procedure();
    }
}
