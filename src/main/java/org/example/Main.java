package org.example;

import java.util.Map;

//Automatically done when trying to add slot enum
import static org.example.Item.Slot.HEAD;
import static org.example.Item.Slot.WEAPON;

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
        Weapon battleAxe = new Weapon("Battle Axe", 1, 12, WEAPON, Weapon.WeaponTypes.AXE);
        Armor helmet = new Armor("Cool Helmet", 2, new HeroAttribute(1,1,1), HEAD, Armor.ArmorType.PLATE);
        System.out.println(battleAxe.getSlot());

        heroJim.equip(battleAxe);
        heroJim.equip(helmet);

        System.out.println("\n");
        for (Map.Entry<Item.Slot, Item> entry : heroJim.getEquipment().entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }

}