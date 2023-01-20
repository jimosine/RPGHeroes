import heroes.Hero;
import heroes.Mage;
import items.*;
import org.junit.jupiter.api.Test;
import utilities.InvalidArmorException;
import utilities.InvalidWeaponException;

import static items.Item.Slot.*;
import static items.Weapon.WeaponTypes.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/* Here we do all the unit testing for the Weapon item class and also test our custom exception messages. These occur
 * when a hero tries to equip weapons which are not suitable for its class or when its level is too low. For these tests
 * we use a Mage object, but they pass for all classes.
 * */
public class WeaponTests {

    //Test if the correct name is returned
    @Test
    void TestWeaponName_ShouldPass() {
        Item staff = new Weapon("Fire Staff", 1, 1, WEAPON, STAFF);
        assertEquals("Fire Staff", staff.getName());
    }

    //Test if the correct level requirement is returned
    @Test
    void TestWeaponLevel_ShouldPass() {
        Item staff = new Weapon("Fire Staff", 1, 1, WEAPON, STAFF);
        assertEquals(1, staff.getRequiredLevel());
    }

    //Test if the correct item slot requirement is returned
    @Test
    void TestWeaponSlot_ShouldPass() {
        Item staff = new Weapon("Fire Staff", 1, 1, WEAPON, STAFF);
        assertEquals(WEAPON, staff.getSlot());
    }
    //Test if the correct weapon type is returned
    @Test
    void TestWeaponType_ShouldPass() {
        Item staff = new Weapon("Fire Staff", 1, 1, WEAPON, STAFF);
        assertEquals(STAFF, staff.getWeaponTypes());
    }

    //Test if the correct weapon damage is returned
    @Test
    void TestWeaponDamage_ShouldPass() {
        Item staff = new Weapon("Fire Staff", 1, 1, WEAPON, STAFF);
        assertEquals(1, staff.getWeaponDamage());
    }

    //Test if the hero can correctly equip weapons by equipping a "Fire Staff" and checking if the name is correct
    @Test
    void TestWeapon_Equip_ShouldPass() throws InvalidArmorException, InvalidWeaponException {
        Weapon staff = new Weapon("Fire Staff", 1, 1, WEAPON, STAFF);
        Hero heroJim = new Mage("Jim");

        heroJim.equip(staff);
        heroJim.getEquipment();
        assertEquals("Fire Staff", staff.getName());
    }

    //Test our custom message when a hero tries to equip a weapon that is too high level
    @Test
    public void TestInvalidWeaponException_LowLevel_ShouldThrowException(){
        Weapon lavaStaff = new Weapon("Lava Staff", 5, 1, WEAPON, STAFF);
        Hero heroJim = new Mage("Jim");
        String expected = "Your level it too low to equip this weapon";


        InvalidWeaponException exception = assertThrows(InvalidWeaponException.class,
                () -> heroJim.equip(lavaStaff));
        String actual = exception.getMessage();
        assertEquals(expected, actual);

    }

    //Test our custom message when a hero tries to equip a weapon that is not suitable for a mage
    @Test
    public void TestInvalidWeaponException_WrongType_ShouldThrowException(){
        Weapon axe = new Weapon("Great Axe", 1, 12, WEAPON, AXE);
        Hero heroJim = new Mage("Jim");
        String expected = "Tried to equip invalid weapon";

        InvalidWeaponException exception = assertThrows(InvalidWeaponException.class,
                () -> heroJim.equip(axe));
        String actual = exception.getMessage();
        assertEquals(expected, actual);

    }
}
