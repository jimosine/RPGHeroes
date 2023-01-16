package org.example;

import java.util.ArrayList;

public class Mage extends Hero{


    public Mage(String name) {
        super(name);
        //this.level = 1;
        this.levelAttributes = new HeroAttribute(1,1,8);

    }

    @Override
    public void levelUp() {
        setLevel(getLevel() + 1); //kan dit ook verkassen naar de Hero.java want telt voor elke type
        HeroAttribute.increaseStats(1,1,5);
    }

    public void setLevel(int lvl){
        level = lvl;
    }

    public int getLevel(){
        return level;
    }

//    public Mage(String name, int level, int levelAttributes, ArrayList<String> validWeaponTypes, ArrayList<String> validArmorTypes) {
//        super(name);
//        this.level = level;
//        this.levelAttributes = levelAttributes;
//        this.validWeaponTypes = validWeaponTypes;
//        this.validArmorTypes = validArmorTypes;
//    }

    //    @Override
//    public String displayStats() {
//        return name + level;
//    }
}

