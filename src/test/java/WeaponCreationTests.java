import org.example.Weapon;
import org.junit.jupiter.api.Test;

import static org.example.Item.Slot.*;
import static org.example.Weapon.WeaponTypes.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeaponCreationTests {
    //Create a basic staff to be used in the testing
    Weapon staff = new Weapon("Fire Staff", 1, 1, WEAPON, STAFF);

    //Test if the correct name is returned
    @Test
    void weaponNameChecker() {
        assertEquals("Fire Staff", staff.getName());
    }

    //Test if the correct level requirement is returned
    @Test
    void weaponLevelChecker() {
        assertEquals(1, staff.getRequiredLevel());
    }

    //Test if the correct item slot requirement is returned
    @Test
    void weaponSlotChecker() {
        assertEquals(WEAPON, staff.getSlot());
    }
    //Test if the correct weapon type is returned
    @Test
    void weaponTypeChecker() {
        assertEquals(STAFF, staff.getWeaponTypes());
    }

    //Test if the correct weapon damage is returned
    @Test
    void weaponDamageChecker() {
        assertEquals(1, staff.getWeaponDamage());
    }
}
