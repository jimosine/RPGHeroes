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

    public Weapon(String name, int requiredLevel, int weaponsDamage, Slot slot, WeaponTypes weaponsType) {
        super(name, requiredLevel, slot);
        this.weaponDamage = weaponDamage;
        this.WeaponTypes = weaponsType;
    }

    @Override
    public Weapon.WeaponTypes getWeaponTypes() {
        return WeaponTypes;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponsDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }
}
