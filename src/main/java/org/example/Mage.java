package org.example;

import java.util.Map;

public class Mage extends Hero{


    public Mage(String name) {
        super(name);
        //this.level = 1;
        this.levelAttributes = new HeroAttribute(1,1,8);

    }


    @Override
    public void levelUp() {
        setLevel(getLevel() + 1); //kan dit ook verkassen naar de Hero.java want telt voor elke type

        //get the current attributes
        HeroAttribute currentAttributes = getLevelAttributes();
        setAttributes(currentAttributes.increaseStats(1,1,5));

    }

    @Override
    public double damage() {
        int weaponDmg = 1;
        double heroDmg = 0;
        for (Map.Entry<Item.Slot, Item> entry : this.getEquipment().entrySet()) {
            if (entry.getKey().toString().equals("WEAPON")) { //nullpointerexception als waarde null is
                //nog even een nullpointerexception maken (dan weaponDmg = 1)
                weaponDmg = entry.getValue().getWeaponDamage();
            } else {
                continue;
            }
        }
        double damagingAttribute = totalAttributes().getDex();
        heroDmg = weaponDmg * (1 + damagingAttribute / 100);
        return heroDmg;
    }
    @Override
    public void equip(Item item) {

        //Double check for ilvl, because if I don't copy it from Hero.equip I lose it?
        int mylvl = level;
        int ilvl = item.getRequiredLevel();
        if (mylvl >= ilvl) {

            String itemType = item.getClass().getSimpleName();

            //Rules for equiping weapons
            if (itemType.equals("Weapon")) {
                String weaponType = item.getWeaponTypes().toString();
                if (weaponType.equals("WAND") || weaponType.equals("STAFF")) { //NICER IF IT CAN BE A LIST OF OPTIONS INSTEAD OF DOUBLE CONDITION
                    System.out.println("GELUKT");
                    equipment.put(item.getSlot(), item);
                } else  {
                    System.out.println("YOU CANT EQUIP THIS WEAPON TYPE");
                }

                //Rules for equiping armor
            } else if (itemType.equals("Armor")) {
                //System.out.println("dit is armor");
                equipment.put(item.getSlot(), item);
            } else {
                System.out.println("niets");
            }
        }
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

//    public Mage(String name, int level, int levelAttributes, ArrayList<String> validWeaponTypes, ArrayList<String> validArmorTypes) {
//        super(name);
//        this.level = level;
//        this.levelAttributes = levelAttributes;
//        this.validWeaponTypes = validWeaponTypes;
//        this.validArmorTypes = validArmorTypes;
//    }

    //    @Override
//    public String displayStats() {
//        return name + level;
//    }
}

