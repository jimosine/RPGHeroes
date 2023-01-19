package items;

import utilities.HeroAttribute;

public abstract class Item  {
    private final Item.Slot Slot;
    public String name;
    public int requiredLevel;

    public abstract HeroAttribute getArmorAttribute(); //anders kan ik die niet gebruiken in CalcAttributes

    public abstract int getWeaponDamage(); //zelfde voor deze

    public enum Slot {
        WEAPON,
        HEAD,
        BODY,
        LEGS
    }

    public Item(String name, int requiredLevel, Slot slot ) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.Slot = slot;
    }

    public Item.Slot getSlot() {
        return Slot;
    }

    // Hopen dat ik nu in item wel .weapontypes mag noemen
    public abstract Weapon.WeaponTypes getWeaponTypes();
    public abstract Armor.ArmorType getArmorTypes();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }
}
