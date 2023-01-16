package org.example;

import java.util.ArrayList;

public abstract class Hero {
    public String name; //moet denk ik eigenlijk private (maar toen kon ik hem niet gebruiken in displayStats in Mage)
    public int level;
    //private int level;
    public HeroAttribute levelAttributes;
    //private ListArray equipment; ??
    private ArrayList<String> validWeaponTypes;
    private ArrayList<String> validArmorTypes;


    public Hero(String name) {
        this.name = name;
        this.level = 1;
        levelAttributes = new HeroAttribute(0,0,0);
    }
    abstract void levelUp();
            // Is it a choice to either make this abstract and put it in child classes
            // or de we want it all here and override the increaseStats in child classes?
//        HeroAttribute.increaseStats(1,1,2);


    public static void equip(){

    }

    public static void damage(){

    }

    public static void totalAttributes(){

    }

    public void displayStats() {
        //omschrijven tot een String Builder
        System.out.println(name);
        System.out.println(this.getClass().getSimpleName());
        System.out.println(level);
        System.out.println(levelAttributes.getStr());
        System.out.println(levelAttributes.getDex());
        System.out.println(levelAttributes.getIntel());
    }
}