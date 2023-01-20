package items;

import utilities.HeroAttribute;


/* Here we have the base class for an Item, which is extended on by the Weapon and Armor item child classes.
 * All items have a name, a required level and belong to a specific item slot. This slot is created through an
 * enumerator, with the possible fields being weapon/head/body/legs
 *  */

//Define the fields
public abstract class Item  {
    private final Item.Slot Slot;
    public String name;
    public int requiredLevel;

    public enum Slot {
        WEAPON,
        HEAD,
        BODY,
        LEGS
    }

    //Items are constructed using its name parameters, required level and item slot
    public Item(String name, int requiredLevel, Slot slot ) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.Slot = slot;
    }

    //There are four abstract methods, which are related to the weapon and armor specific types. With armor items, there
    //is also a set of stats which is saved as a HeroAttribute object, and with weapons there is a specific weapon
    //damage integer declared
    public abstract Weapon.WeaponTypes getWeaponTypes();
    public abstract Armor.ArmorType getArmorTypes();
    public abstract HeroAttribute getArmorAttribute();
    public abstract int getWeaponDamage();

    //Getters and setters
    public Item.Slot getSlot() {
        return Slot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

}
