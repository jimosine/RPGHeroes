import heroes.Hero;
import heroes.Mage;
import items.*;
import org.junit.jupiter.api.Test;
import utilities.HeroAttribute;
import utilities.InvalidArmorException;
import utilities.InvalidWeaponException;

import static items.Armor.ArmorType.CLOTH;
import static items.Item.Slot.HEAD;
import static items.Item.Slot.WEAPON;
import static items.Weapon.WeaponTypes.STAFF;
import static items.Weapon.WeaponTypes.WAND;
import static org.junit.jupiter.api.Assertions.assertEquals;

/* In this class we do all unit testing relating to the Hero.damage() method. We do tests for heroes with no items,
*  with weapons, with armor equipped and with both equipped. For these tests we use a Mage object, but they pass for
* all classes. */
public class DamageTests {

    //Test if damage is correct without any items
    @Test
    public void TestDamage_NoItems_ShouldPass(){
        Hero heroJim = new Mage("Jim");
        double expected = 1* (1 + (8.0 / 100));
        double damage = heroJim.damage();
        assertEquals(expected, damage);
    }

    //Test if damage is correct with one weapon with a weapon damage of 2
    @Test
    public void TestDamage_OneWeapon_ShouldPass() throws InvalidArmorException, InvalidWeaponException {
        Hero heroJim = new Mage("Jim");
        Weapon staff = new Weapon("Fire Staff", 1, 2, WEAPON, STAFF);
        double expected = 2 * (1 + (8.0 / 100));

        heroJim.equip(staff);
        double damage = heroJim.damage();
        assertEquals(expected, damage);
    }

    //Test if damage is correct with a replacement weapon with 2 damage
    @Test
    public void TestDamage_ReplacedWeapon_ShouldPass() throws InvalidArmorException, InvalidWeaponException {
        Hero heroJim = new Mage("Jim");
        Weapon staff = new Weapon("Fire Staff", 1, 2, WEAPON, STAFF);
        Weapon wand = new Weapon("Mystic Wand", 1, 2, WEAPON, WAND);
        double expected = 2 * (1 + (8.0 / 100));

        heroJim.equip(staff);
        heroJim.equip(wand);
        double damage = heroJim.damage();
        assertEquals(expected, damage);
    }

    //Test if damage is correct with armor equipped and a weapon
    @Test
    public void TestDamage_WeaponAndArmor_ShouldPass() throws InvalidArmorException, InvalidWeaponException {
        Hero heroJim = new Mage("Jim");
        Weapon staff = new Weapon("Fire Staff", 1, 2, WEAPON, STAFF);
        Weapon wand = new Weapon("Mystic Wand", 1, 2, WEAPON, WAND);
        HeroAttribute armorStats = new HeroAttribute(1,1,1);
        Armor hat = new Armor("Pointy Hat", 1, armorStats, HEAD, CLOTH);
        double expected = 2 * (1 + ((8.0+1.0) / 100));

        heroJim.equip(staff);
        heroJim.equip(wand);
        heroJim.equip(hat);
        double damage = heroJim.damage();
        assertEquals(expected, damage);
    }
}
