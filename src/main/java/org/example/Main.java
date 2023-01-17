package org.example;

import java.util.Map;

//Automatically done when trying to add slot enum
import static org.example.Item.Slot.*;
import static org.example.Armor.ArmorType.*;

public class Main {
    public static void main(String[] args) {
        Mage heroJim = new Mage("Jim");
        heroJim.displayStats();
        heroJim.levelUp();

        heroJim.displayStats();

        //Dit hoeft niet
        System.out.println("\n");
        for (Map.Entry<Item.Slot, Item> entry : heroJim.getEquipment().entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        //Item test
        HeroAttribute a = new HeroAttribute(32,14,72);
        HeroAttribute b = new HeroAttribute(35,9,32);
        HeroAttribute c = new HeroAttribute(11,10,10);

        System.out.println(a.getStr());


        Armor dress = new Armor("dress",2,a, BODY, CLOTH);
        Armor legging = new Armor("leggings",2,b, LEGS, CLOTH);
        Weapon battleAxe = new Weapon("Battle Axe", 1, 12, WEAPON, Weapon.WeaponTypes.AXE);
        Armor helmet = new Armor("Cool Helmet", 2, c, HEAD, PLATE);

        heroJim.equip(battleAxe);
        heroJim.equip(helmet);
        heroJim.equip(dress);
        heroJim.equip(legging);

        System.out.println("\n");
        for (Map.Entry<Item.Slot, Item> entry : heroJim.getEquipment().entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println(heroJim.totalAttributes().getStr()); //geeft raar gedrag, verander maar de str van de helm
    }

}