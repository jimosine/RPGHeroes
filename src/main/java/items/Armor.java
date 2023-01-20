package items;

import utilities.HeroAttribute;


/* The armor class is a subclass of the Item class. Here we have a new enumerator, which defines the type of armor
 * we are dealing with. Each piece of armor also has a certain amount of stats coupled to it, which are defined as
 * a HeroAttribute object
 *  */

//Define fields
public class Armor extends Item {
    HeroAttribute armorAttribute;
    private final Armor.ArmorType ArmorTypes;
    public enum ArmorType {
        CLOTH,
        LEATHER,
        MAIL,
        PLATE
    }

    //New armor items are constructed using the general name parameters, required level, item slot and armor specific
    //parameters for the armor's attributes and type.
    public Armor(String name, int requiredLevel, HeroAttribute armorAttribute, Item.Slot slot, ArmorType armorTypes) {
        super(name, requiredLevel, slot);
        this.armorAttribute = armorAttribute;
        this.ArmorTypes = armorTypes;
    }

    //Getters
    public HeroAttribute getArmorAttribute() {
        return armorAttribute;
    }

    public ArmorType getArmorTypes() {
        return ArmorTypes;
    }

    public int getWeaponDamage() {
        return 0;
    }

    public Weapon.WeaponTypes getWeaponTypes() {
        return null;
    }

}
