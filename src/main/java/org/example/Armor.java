package org.example;

public class Armor extends Item {
    HeroAttribute armorAttribute;

    public Armor(String name, int requiredLevel, Slot slot) {
        super(name, requiredLevel, slot);
    }

    enum armorType {
        CLOTH,
        LEATHER,
        MAIL,
        PLATE
    }

}
