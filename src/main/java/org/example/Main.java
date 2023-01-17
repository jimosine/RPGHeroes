package org.example;

import java.util.Map;

//Automatically done when trying to add slot enum
import static org.example.Item.Slot.*;
import static org.example.Armor.ArmorType.*;
import static org.example.Weapon.WeaponTypes.*;

public class Main {
    public static void main(String[] args) throws InvalidWeaponException, InvalidArmorException {
        Mage heroJim = new Mage("Jim");
        heroJim.levelUp();

        //Dit hoeft niet
//        System.out.println("\n");
//        for (Map.Entry<Item.Slot, Item> entry : heroJim.getEquipment().entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }

        //Item test
        HeroAttribute a = new HeroAttribute(32,14,72);
        HeroAttribute b = new HeroAttribute(35,9,32);
        HeroAttribute c = new HeroAttribute(11,10,10);


        Armor dress = new Armor("dress",5,a, BODY, CLOTH);
        Armor legging = new Armor("leggings",2,b, LEGS, CLOTH);
        Weapon battleAxe = new Weapon("Fire Staff", 1, 12, WEAPON, STAFF);
        Armor helmet = new Armor("Cool Helmet", 2, c, HEAD, PLATE);

        try {
            heroJim.equip(battleAxe);
        } catch (InvalidWeaponException e) {
            System.out.println(e.getMessage());
        }
        try {
            heroJim.equip(helmet);
        }
        catch (InvalidArmorException e) {
            System.out.println(e.getMessage());
        }
        try {
            heroJim.equip(dress);
        }
        catch (InvalidArmorException e) {
            System.out.println(e.getMessage());
        }
        try {
            heroJim.equip(legging);
        }
        catch (InvalidArmorException e) {
            System.out.println(e.getMessage());
        }


//        System.out.println("\n");
//        for (Map.Entry<Item.Slot, Item> entry : heroJim.getEquipment().entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }


        heroJim.displayStats();
    }

}