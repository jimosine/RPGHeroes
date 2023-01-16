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

    public void setEquipment(Map<Item.Slot, Item> equipment) {
        this.equipment = equipment;
    }

    public void equip(Item item){
        int mylvl = level;
        int ilvl = item.getRequiredLevel();
        if (mylvl >= ilvl) {
            equipment.put(item.getSlot(), item);
        }
        else {
            System.out.println("mag niet");
        }
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