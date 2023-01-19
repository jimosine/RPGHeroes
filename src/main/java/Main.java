//Automatically done when trying to add slot enum
import heroes.Mage;
import items.Armor;
import items.Weapon;
import utilities.HeroAttribute;
import utilities.InvalidArmorException;
import utilities.InvalidWeaponException;

import static items.Item.Slot.*;

public class Main {
    public static void main(String[] args) throws InvalidWeaponException, InvalidArmorException {
        Mage heroJim = new Mage("Jim");
        heroJim.levelUp();

        //Dit hoeft niet
//        System.out.println("\n");
//        for (Map.Entry<Item.Slot, Item> entry : heroJim.getEquipment().entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }

        //Item test
        HeroAttribute a = new HeroAttribute(32,14,72);
        HeroAttribute b = new HeroAttribute(35,9,32);
        HeroAttribute c = new HeroAttribute(11,10,10);
//        HeroAttribute d = new HeroAttribute(99,99,99);


        Armor dress = new Armor("dress",5,a, BODY, Armor.ArmorType.CLOTH);
        Armor legging = new Armor("leggings2",2,b, LEGS, Armor.ArmorType.CLOTH);
        Weapon battleAxe = new Weapon("Fire Staff", 1, 12, WEAPON, Weapon.WeaponTypes.STAFF);
        Armor helmet = new Armor("Cool Helmet", 2, c, HEAD, Armor.ArmorType.PLATE);
//        Armor legging2 = new Armor("leggings2",2,d, LEGS, CLOTH);

        try {
            heroJim.equip(battleAxe);
        } catch (InvalidWeaponException e) {
            System.out.println(e.getMessage());
        }
        try {
            heroJim.equip(helmet);
        }
        catch (InvalidArmorException e) {
            System.out.println(e.getMessage());
        }
        try {
            heroJim.equip(dress);
        }
        catch (InvalidArmorException e) {
            System.out.println(e.getMessage());
        }
        try {
            heroJim.equip(legging);
        }
        catch (InvalidArmorException e) {
            System.out.println(e.getMessage());
        }
//        try {
//            heroJim.equip(legging2);
//        }
//        catch (InvalidArmorException e) {
//            System.out.println(e.getMessage());
//        }


//        System.out.println("\n");
//        for (Map.Entry<Item.Slot, Item> entry : heroJim.getEquipment().entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }

        System.out.println(heroJim.displayStats());
    }

}