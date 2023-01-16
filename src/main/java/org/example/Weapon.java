package org.example;

public class Weapon extends Item {
    int weaponDamage;
    enum weaponTypes{
        AXE,
        BOW,
        DAGGER,
        HAMMER,
        STAFF,
        SWORD,
        WAND
    }

    public Weapon(int weaponsDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponsDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }
}
