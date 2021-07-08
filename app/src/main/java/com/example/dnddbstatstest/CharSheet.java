package com.example.dnddbstatstest;

public class CharSheet {
    private String name;
    private int id;
    private int str;
    private int dex;
    private int con;
    private int wis;
    private int intel;
    private int cha;

    public CharSheet() {
    }

    public CharSheet(String name, int id, int str, int dex, int con,  int wis, int intel, int cha) {
        this.name = name;
        this.id = id;
        this.str = str;
        this.dex = dex;
        this.con = con;
        this.wis = wis;
        this.intel = intel;
        this.cha = cha;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getCon() {
        return con;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public int getIntel() {
        return intel;
    }

    public void setIntel(int intel) {
        this.intel = intel;
    }

    public int getWis() {
        return wis;
    }

    public void setWis(int wis) {
        this.wis = wis;
    }

    public int getCha() {
        return cha;
    }

    public void setCha(int cha) {
        this.cha = cha;
    }
    public String toString()
    {
        return "Name:" + name + " CharID:" + id + " Str:" + str +" Dex:"+dex+" Con:"+con+" Int:"+intel+" Wis:"+wis+" Cha:"+cha;
    }

}
