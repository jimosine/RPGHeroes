package org.example;

public class Mage extends Hero{


    public Mage(String name) {
        super(name);
        //this.level = 1;
        this.levelAttributes = new HeroAttribute(1,1,8);

    }

    @Override
    public void levelUp() {
        setLevel(getLevel() + 1); //kan dit ook verkassen naar de Hero.java want telt voor elke type
        HeroAttribute.increaseStats(1,1,5);
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
                System.out.println("dit is armor");
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

