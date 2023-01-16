package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Hero {
    public String name; //moet denk ik eigenlijk private (maar toen kon ik hem niet gebruiken in displayStats in Mage)
    public int level;
    //private int level;
    public HeroAttribute levelAttributes;

    public Map<Item.slot, Item> equipment; //map of items van type <slot, item>

    private ArrayList<String> validWeaponTypes;
    private ArrayList<String> validArmorTypes;


    public Hero(String name) {
        this.name = name;
        this.level = 1;
        levelAttributes = new HeroAttribute(0,0,0);
        /* Would like to improve this more after giving it somre more detail
        *
        * //        this.equipment = Map.of(
        * //                Item.slot.WEAPON, null,
        * //                Item.slot.HEAD , null,
        * //                Item.slot.LEGS,  null,
        * //                Item.slot.BODY, null
        * //        );
        * */
        this.equipment = new HashMap<>();
        equipment.put(Item.slot.WEAPON, null);
        equipment.put(Item.slot.HEAD, null);
        equipment.put(Item.slot.BODY, null);
        equipment.put(Item.slot.LEGS, null);


    }
    abstract void levelUp();
            // Is it a choice to either make this abstract and put it in child classes
            // or de we want it all here and override the increaseStats in child classes?
//        HeroAttribute.increaseStats(1,1,2);


    public Map<Item.slot, Item> getEquipment() {
        return equipment;
    }

    public void setEquipment(Map<Item.slot, Item> equipment) {
        this.equipment = equipment;
    }

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