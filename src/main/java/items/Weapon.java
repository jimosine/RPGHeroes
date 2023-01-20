package items;

import utilities.HeroAttribute;

/* The weapon class is a subclass of the Item class. Here we have a new enumerator, which defines the type of weapon
 * we are dealing with.
 *  */

//Define fields
public class Weapon extends Item {
    int weaponDamage;
    private final Weapon.WeaponTypes WeaponTypes;
    public enum WeaponTypes{
        AXE,
        BOW,
        DAGGER,
        HAMMER,
        STAFF,
        SWORD,
        WAND
    }

    //New weapons are constructed using the general name parameters, required level, item slot (which we set to weapon
    // by default) and weapon specific parameters for the weapon's damage and type.
    public Weapon(String name, int requiredLevel, int weaponDamage, Slot WEAPON, WeaponTypes weaponsType) {
        super(name, requiredLevel, WEAPON);
        this.weaponDamage = weaponDamage;
        this.WeaponTypes = weaponsType;
    }

    //Getters
    public Weapon.WeaponTypes getWeaponTypes() {
        return WeaponTypes;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public Armor.ArmorType getArmorTypes() {
        return null;
    }

    public HeroAttribute getArmorAttribute() {
        return null;
    }
}
