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

public class DamageTests {

    @Test
    public void noWeaponDamageTest(){
        Hero heroJim = new Mage("Jim");
        double expected = 1* (1 + (8.0 / 100));
        double damage = heroJim.damage();
        assertEquals(expected, damage);
    }

    @Test
    public void normalWeaponDamageTest() throws InvalidArmorException, InvalidWeaponException {
        Hero heroJim = new Mage("Jim");
        Weapon staff = new Weapon("Fire Staff", 1, 2, WEAPON, STAFF);
        double expected = 2 * (1 + (8.0 / 100));

        heroJim.equip(staff);
        double damage = heroJim.damage();
        assertEquals(expected, damage);
    }

    @Test
    public void replacedWeaponDamageTest() throws InvalidArmorException, InvalidWeaponException {
        Hero heroJim = new Mage("Jim");
        Weapon staff = new Weapon("Fire Staff", 1, 2, WEAPON, STAFF);
        Weapon wand = new Weapon("Mystic Wand", 1, 2, WEAPON, WAND);
        double expected = 2 * (1 + (8.0 / 100));

        heroJim.equip(staff);
        heroJim.equip(wand);
        double damage = heroJim.damage();
        assertEquals(expected, damage);
    }

    @Test
    public void armorAndWeaponDamageTest() throws InvalidArmorException, InvalidWeaponException {
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
