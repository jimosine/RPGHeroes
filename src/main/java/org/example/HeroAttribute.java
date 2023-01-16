package org.example;

public class HeroAttribute {
    public static int str;
    public static int dex;
    public static int intel;

    public HeroAttribute(int str, int dex, int intel){
       this.str = str;
       this.dex = dex;
       this.intel = intel;
    }

    public static void increaseStats(int str, int dex, int intel){
        setStr(str + getStr());
        setDex(dex + getDex());
        setIntel(intel + getIntel());
    }

    public static void setStr(int strength){
        str = strength;
    }

    public static int getStr(){
        return str;
    }

    public static void setDex(int dexterity){
        dex = dexterity;
    }

    public static int getDex(){
        return dex;
    }

    public static void setIntel(int intelligence){
        intel = intelligence;
    }

    public static int getIntel(){
        return intel;
    }
}
