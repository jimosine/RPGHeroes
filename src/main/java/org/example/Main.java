package org.example;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Mage heroJim = new Mage("Jim");
        heroJim.displayStats();
        heroJim.levelUp();

        heroJim.displayStats();

        //Dit hoeft niet
        System.out.println("\n");
        for (Map.Entry<Item.slot, Item> entry : heroJim.getEquipment().entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

}