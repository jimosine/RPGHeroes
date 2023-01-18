package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Mage extends Hero{


    public Mage(String name) {
        super(name);
        //this.level = 1;
        this.levelAttributes = new HeroAttribute(1,1,8);

        //Add all valid item types
        validWeaponTypes.add("WAND");
        validWeaponTypes.add("STAFF");
        validArmorTypes.add("CLOTH");
    }


    @Override
    public void levelUp() {
        setLevel(getLevel() + 1); //kan dit ook verkassen naar de Hero.java want telt voor elke type

        //get the current attributes
        HeroAttribute currentAttributes = getLevelAttributes();
        setAttributes(currentAttributes.increaseStats(1,1,5));

    }

    @Override
    public double damage() throws NullPointerException {
        int weaponDmg = 1;
        double heroDmg = 0;
        for (Map.Entry<Item.Slot, Item> entry : this.getEquipment().entrySet()) { //omschrijven om met key weapon de value op te halen
            try{
            if (entry.getKey().toString().equals("WEAPON")) {
                weaponDmg = entry.getValue().getWeaponDamage();
            }} catch (NullPointerException e2){
                weaponDmg = 1;
                }
//            else {
//                continue;
//            }
        }
        double damagingAttribute = totalAttributes().getIntel();
        heroDmg = weaponDmg * (1 + damagingAttribute / 100);
        return heroDmg;
    }
    @Override
    public void equip(Item item) throws InvalidWeaponException, InvalidArmorException {


        int mylvl = level;
        int ilvl = item.getRequiredLevel();
        String itemType = item.getClass().getSimpleName();

        if (itemType.equals("Weapon")) {
            String weaponType = item.getWeaponTypes().toString();
            //Rules for equiping weapons

            if (mylvl < ilvl) throw new InvalidWeaponException("Tried to equip invalid weapon");
            if (!validWeaponTypes.contains(weaponType))
                throw new InvalidWeaponException("Tried to equip invalid weapon");
            equipment.put(item.getSlot(), item);
        } else if (itemType.equals("Armor")) {
            String armorType = item.getArmorTypes().toString();
            if (mylvl < ilvl) throw new InvalidWeaponException("Tried to equip invalid weapon");
            if (!validArmorTypes.contains(armorType))
                throw new InvalidWeaponException("Tried to equip invalid armor");
            equipment.put(item.getSlot(), item);
        }
//        if (itemType.equals("Weapon") && mylvl >= ilvl) {
//            //String weaponType = item.getWeaponTypes().toString();
//            if (weaponType.equals("WAND") || weaponType.equals("STAFF")) { //NICER IF IT CAN BE A LIST OF OPTIONS INSTEAD OF DOUBLE CONDITION
//                equipment.put(item.getSlot(), item);
//            } else{
//                throw new InvalidWeaponException("Tried to equip invalid weapon");
//            }
//
//        //Rules for equiping armor
//        } else if (itemType.equals("Armor") && mylvl >= ilvl) {
//
//            String armorType = item.getArmorTypes().toString();
//            if (armorType.equals("CLOTH")){ //NICER IF IT CAN BE A LIST OF OPTIONS INSTEAD OF DOUBLE CONDITION
//                equipment.put(item.getSlot(), item);
//            } else{
//                throw new InvalidArmorException("Tried to equip invalid armor");
//            }
//        }

    }

    public void setLevel(int lvl){
        level = lvl;
    }

    public int getLevel(){
        return level;
    }

    public HeroAttribute getAttributes(){
        return levelAttributes;
    }

    public void setAttributes(HeroAttribute attributes){
        levelAttributes = attributes;
    }

}

