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

    public Armor(String name, int requiredLevel, HeroAttribute armorAttribute, Item.Slot slot, ArmorType armorTypes) {
        super(name, requiredLevel, slot);
        this.armorAttribute = armorAttribute;
        this.ArmorTypes = armorTypes;
    }

    public HeroAttribute getArmorAttribute() {
        return armorAttribute;
    }

    public void setArmorAttribute(HeroAttribute armorAttribute) {
        this.armorAttribute = armorAttribute;
    }

    @Override
    public Weapon.WeaponTypes getWeaponTypes() {
        return null;
    }

    @Override
    ArmorType getArmorTypes() {
        return ArmorTypes;
    }

    public int getWeaponDamage() { //MOEST DIT TOEVOEGEN>???
        return 0;
    }


}
