/* Imports */
import heroes.Mage;
import items.Armor;
import items.Weapon;
import utilities.HeroAttribute;
import utilities.InvalidArmorException;
import utilities.InvalidWeaponException;

import static items.Armor.ArmorType.*;
import static items.Item.Slot.*;
import static items.Weapon.WeaponTypes.*;

/* Main doesn't include any import methods or checks, it just served as a tool to check for myself if
* everything was working and debugging before including unit tests.
*   */

public class Main {
    public static void main(String[] args) throws InvalidWeaponException, InvalidArmorException {
        //Create and level a Mage hero
        Mage heroJim = new Mage("Jim");
        heroJim.levelUp();

        //Item test, instantiate attributes for items and instantiate actual items
        HeroAttribute a = new HeroAttribute(32,14,72);
        HeroAttribute b = new HeroAttribute(35,9,32);
        HeroAttribute c = new HeroAttribute(11,10,10);


        Armor dress = new Armor("Dress",5,a, BODY, CLOTH);
        Armor legging = new Armor("Leggings",2,b, LEGS, CLOTH);
        Weapon staff = new Weapon("Fire Staff", 1, 12, WEAPON, STAFF);
        Armor helmet = new Armor("Cool Helmet", 2, c, HEAD, PLATE);

        //Try equipping the items and catch + display the correct error messages
        try {
            heroJim.equip(staff);
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

        //Display all the to see if things are working correctly
        System.out.println(heroJim.displayStats());

    }

}