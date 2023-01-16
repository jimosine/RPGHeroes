package org.example;

public class Armor extends Item {
    HeroAttribute armorAttribute;
    enum armorType {
        CLOTH,
        LEATHER,
        MAIL,
        PLATE
    }

    public Armor(HeroAttribute armorAttribute) {
        this.armorAttribute = armorAttribute;
    }

    public HeroAttribute getArmorAttribute() {
        return armorAttribute;
    }

    public void setArmorAttribute(HeroAttribute armorAttribute) {
        this.armorAttribute = armorAttribute;
    }
}
