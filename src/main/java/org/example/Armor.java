package org.example;

public class Armor extends Item {
    HeroAttribute armorAttribute;
    private final Armor.ArmorType ArmorTypes;


    enum ArmorType {
        CLOTH,
        LEATHER,
        MAIL,
        PLATE
    }

    public Armor(String name, int requiredLevel, Item.Slot slot, ArmorType armorTypes) {
        super(name, requiredLevel, slot);
        this.armorAttribute = armorAttribute;
        this.ArmorTypes = armorTypes;
    }

    @Override
    public Weapon.WeaponTypes getWeaponTypes() {
        return null;
    }
}
