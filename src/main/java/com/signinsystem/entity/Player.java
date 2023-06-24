package com.signinsystem.entity;

import java.util.*;


public class Player {
    private String name;
    private String password;
    private int day;
    private Bag bag;


    public Player(String name, String password) {
        this.name = name;
        this.password = password;
        bag = new Bag();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(name, player.name) && Objects.equals(password, player.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }
}
