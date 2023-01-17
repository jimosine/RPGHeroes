package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Hero {
    public String name; //moet denk ik eigenlijk private (maar toen kon ik hem niet gebruiken in displayStats in Mage)
    public int level;
    //private int level;
    public HeroAttribute levelAttributes;

    public Map<Item.Slot, Item> equipment; //map of items van type <slot, item>

    public ArrayList<String> validWeaponTypes;
    public ArrayList<String> validArmorTypes;


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
        equipment.put(Item.Slot.WEAPON, null);
        equipment.put(Item.Slot.HEAD, null);
        equipment.put(Item.Slot.BODY, null);
        equipment.put(Item.Slot.LEGS, null);


    }
    abstract void levelUp();
            // Is it a choice to either make this abstract and put it in child classes
            // or de we want it all here and override the increaseStats in child classes?
//        HeroAttribute.increaseStats(1,1,2);


    public Map<Item.Slot, Item> getEquipment() {
        return equipment;
    }

    public HeroAttribute getLevelAttributes() {
        return levelAttributes;
    }

    public void setEquipment(Map<Item.Slot, Item> equipment) {
        this.equipment = equipment;
    }

   //Maybe not abstract and do level check here?
    abstract void equip(Item item) throws InvalidWeaponException, InvalidArmorException;

    abstract double damage();

    /* Dit allemaal netjes maken nog! */
    public HeroAttribute totalAttributes() {
        int total_str = 0;
        int total_dex = 0;
        int total_intel = 0;
        //Loop over each <key,value> pair in our Equipment Map
        for (Map.Entry<Item.Slot, Item> entry : this.getEquipment().entrySet()) {
            //If entry is a weapon, don't do anything (except catch NullExceptions)
            if(entry.getKey().toString().equals("WEAPON")){ //doe niets MAAAAAR: nullpointerexception als waarde null is
            } else {
                //It could be that you are wearing no armor, so catch the NullExceptions
                //Otherwise if you are wearing, add its stats to the total counters
                try{
                    HeroAttribute values = entry.getValue().getArmorAttribute();
                    total_str += values.getStr();
                    total_dex += values.getDex();
                    total_intel += values.getIntel();
                } catch (NullPointerException e1){
//                    System.out.print("Je draagt niets in slot: ");
//                    System.out.println(entry.getKey().toString());
                }
            }
        }
        total_str += getLevelAttributes().getStr();
        total_dex += getLevelAttributes().getDex();
        total_intel += getLevelAttributes().getIntel();
        return new HeroAttribute(total_str, total_dex,total_intel);
    }

    public void displayStats() {
        //omschrijven tot een String Builder
        System.out.println("Name: " + name);
        System.out.println("Class: " + this.getClass().getSimpleName());
        System.out.println("Level: " + level);
        HeroAttribute att1 = totalAttributes();
        System.out.println("Total strength: " + att1.getStr());
        System.out.println("Total dexterity: " + att1.getDex());
        System.out.println("Total intelligence: " + att1.getIntel());
        System.out.println("Total damage: " + damage());
    }

}