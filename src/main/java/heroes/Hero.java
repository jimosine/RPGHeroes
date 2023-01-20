package heroes;

import utilities.HeroAttribute;
import utilities.InvalidArmorException;
import utilities.InvalidWeaponException;
import items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*In this class we have all the public facing fields and methods that a Hero requires. Some are abstract and are
* overwritten in the child classes, as values differ between children */

//Set all the fields
public abstract class Hero {
    public String name;
    public int level;
    public HeroAttribute levelAttributes;
    public Map<Item.Slot, Item> equipment;
    public ArrayList<String> validWeaponTypes;
    public ArrayList<String> validArmorTypes;

    //Constructor for our base Hero class. The only parameter the user has to give is the Hero's name.
    //All heroes start at level 1, and have no items equipped. The valid items arrays are overwritten in the child
    //classes
    public Hero(String name) {
        this.name = name;
        this.level = 1;
        this.equipment = new HashMap<>();
        equipment.put(Item.Slot.WEAPON, null);
        equipment.put(Item.Slot.HEAD, null);
        equipment.put(Item.Slot.BODY, null);
        equipment.put(Item.Slot.LEGS, null);
        this.validWeaponTypes = new ArrayList<>();
        this.validArmorTypes = new ArrayList<>();
    }

    //Abstract method for leveling our Hero. This is overwritten in the child classes, as it is different per class
    //which stats are increased.
    public abstract void levelUp();

    //Method for equipping items which is used by all heroes in the same way. The only difference is the type of
    //weapons or armor a hero class could equip, which is set in validArmorTypes and validWeaponTypes. These fields are
    //overwritten in the child classes. Two custom exceptions have been written, which return messages when the hero's
    //level is lower than the required item level and when a hero tries to equip an item out of their scope.

    public void equip(Item item) throws InvalidWeaponException, InvalidArmorException{

        //Retrieve the required level to equip an item and its class (weapon or armor)
        int itemLevel = item.getRequiredLevel();
        String itemType = item.getClass().getSimpleName();

        //When an item is a weapon, we want to retrieve its type and fail if the hero class is not eligible to
        //equip this weapon type or when its level is too low. Otherwise, insert the item in the correct item slot in
        //the hero's equipment variable
        if (itemType.equals("Weapon")) {
            String weaponType = item.getWeaponTypes().toString();
            if (level < itemLevel) throw new InvalidWeaponException("Your level it too low to equip this weapon");
            if (!validWeaponTypes.contains(weaponType))
                throw new InvalidWeaponException("Tried to equip invalid weapon");
            equipment.put(item.getSlot(), item);


        //Otherwise, we are dealing with an armor item. Same rules and logic apply, but we give a different error
        //message.
        } else if (itemType.equals("Armor")) {
            String armorType = item.getArmorTypes().toString();
            if (level < itemLevel) throw new InvalidArmorException("Your level it too low to equip this armor");
            if (!validArmorTypes.contains(armorType))
                throw new InvalidArmorException("Tried to equip invalid armor");
            equipment.put(item.getSlot(), item);
        }
    }

    //Abstract method for calculating the damage our Hero is currently able to dish out.
    // This is overwritten in the child classes, as it is different per class which attributes are increased.
    public abstract double damage();

    //Method for calculating a hero's total amount of attributes. This is done by summing over all the contributing
    //items (which are armor pieces) and adding these numbers up to the attributes which belong to our hero.
    public HeroAttribute totalAttributes() {

        //Set the total attributes to zero
        int total_str = 0;
        int total_dex = 0;
        int total_intel = 0;
        //Loop over each <key,value> pair in our Equipment Map
        //A <key, value> pair consists of an <Item slot, Item> pair
        for (Map.Entry<Item.Slot, Item> entry : this.getEquipment().entrySet()) {
            //Weapons do not have any attributes, so disregard these items
            if(!entry.getKey().toString().equals("WEAPON")){
                //We have to try and catch any NullPointerExceptions, as a hero could also be wearing no items.
                //In that case, the item is set to null by our constructor method
                try{
                    //Get the three separate attributes, and add them to the total
                    HeroAttribute values = entry.getValue().getArmorAttribute();
                    total_str += values.getStr();
                    total_dex += values.getDex();
                    total_intel += values.getIntel();
                    //Do nothing if you are not wearing an item in said item slot
                } catch (NullPointerException e1){
                }
            }
        }
        //Add the hero's own attributes to the total as well
        total_str += getLevelAttributes().getStr();
        total_dex += getLevelAttributes().getDex();
        total_intel += getLevelAttributes().getIntel();
        //Return as a HeroAttribute object
        return new HeroAttribute(total_str, total_dex,total_intel);
    }

    //Method for displaying all hero related information. Makes use of two methods (totalAttributes() and damage()
    // as discussed earlier. Uses a StringBuilder to append the data to our string.
    public String displayStats() {
        StringBuilder str = new StringBuilder();
        str.append(name);
        str.append(this.getClass().getSimpleName());
        str.append(level);
        HeroAttribute att1 = totalAttributes();
        str.append(att1.getStr());
        str.append(att1.getDex());
        str.append(att1.getIntel());
        str.append(damage());
        //omschrijven tot een String Builder
//        System.out.println("Name: " + name);
//        System.out.println("Class: " + this.getClass().getSimpleName());
//        System.out.println("Level: " + level);
//
//        System.out.println("Total strength: " + att1.getStr());
//        System.out.println("Total dexterity: " + att1.getDex());
//        System.out.println("Total intelligence: " + att1.getIntel());
//        System.out.println("Total damage: " + damage());

        return str.toString();
    }

    //Necessary getters and setters
    public String getName() {
        return name;
    }
    public void setLevel(int lvl){
        level = lvl;
    }

    public int getLevel() {
        return level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Item.Slot, Item> getEquipment() {
        return equipment;
    }

    public HeroAttribute getLevelAttributes() {
        return levelAttributes;
    }

    public void setAttributes(HeroAttribute attributes){
        levelAttributes = attributes;
    }


}