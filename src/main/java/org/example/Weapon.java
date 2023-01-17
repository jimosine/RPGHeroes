package org.example;

public class Weapon extends Item {
    int weaponDamage;
    private final Weapon.WeaponTypes WeaponTypes;
    enum WeaponTypes{
        AXE,
        BOW,
        DAGGER,
        HAMMER,
        STAFF,
        SWORD,
        WAND
    }

    public Weapon(String name, int requiredLevel, int weaponDamage, Slot slot, WeaponTypes weaponsType) {
        super(name, requiredLevel, slot);
        this.weaponDamage = weaponDamage;
        this.WeaponTypes = weaponsType;
    }

    @Override
    public Weapon.WeaponTypes getWeaponTypes() {
        return WeaponTypes;
    }

    @Override
    Armor.ArmorType getArmorTypes() {
        return null;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponsDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public HeroAttribute getArmorAttribute() { //nmoest ik doen voor calculating total attributes, needs fix
        return null;
    }
}
