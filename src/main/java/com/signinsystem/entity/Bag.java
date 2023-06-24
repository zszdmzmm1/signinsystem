package com.signinsystem.entity;

import java.util.ArrayList;
import java.util.List;

public class Bag {
    private int money;
    private List<Gift> gifts = new ArrayList<>();

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<Gift> getGifts() {
        return gifts;
    }

    public void setGifts(List<Gift> gifts) {
        this.gifts = gifts;
    }
}
