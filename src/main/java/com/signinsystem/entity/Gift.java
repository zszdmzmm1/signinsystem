package com.signinsystem.entity;

import java.util.Objects;

public class Gift {
    private String name;
    private int attack;
    private int defence;
    private int hP;
    private int iD;

    public Gift(String name, int attack, int defence, int hP, int iD) {
        this.name = name;
        this.attack = attack;
        this.defence = defence;
        this.hP = hP;
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int gethP() {
        return hP;
    }

    public void sethP(int hP) {
        this.hP = hP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gift gift = (Gift) o;
        return Objects.equals(name, gift.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Gift{" +
                "name='" + name + '\'' +
                ", attack=" + attack +
                ", defence=" + defence +
                ", hP=" + hP +
                ", iD=" + iD +
                '}';
    }
}
