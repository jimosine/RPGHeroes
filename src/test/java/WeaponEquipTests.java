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

public class WeaponEquipTests {

    //!MISSCHIEN DUS TWEE SOORTEN EQUIPS MAKEN, DAN HOEF JE NIET BEIDE EXCEPTIONS TE THROWEN

    //Test if the hero can correctly equip weapons
    @Test
    void weaponEquipChecker() throws InvalidArmorException, InvalidWeaponException {
        Weapon staff = new Weapon("Fire Staff", 1, 1, WEAPON, STAFF);
        Hero heroJim = new Mage("Jim");

        heroJim.equip(staff);
        heroJim.getEquipment();
        assertEquals("Fire Staff", staff.getName());
    }

    @Test
    public void weaponIllegalLevelChecker(){

        // Arrange
        Weapon lavaStaff = new Weapon("Lava Staff", 5, 1, WEAPON, STAFF);
        Hero heroJim = new Mage("Jim");
        String expected = "Tried to equip invalid weapon";


       // Act & Assert
        InvalidWeaponException exception = assertThrows(InvalidWeaponException.class,
                () -> heroJim.equip(lavaStaff));
        String actual = exception.getMessage();
        assertEquals(expected, actual);

    }

    @Test
    public void weaponIllegalTypeChecker(){

        // Arrange
        Weapon axe = new Weapon("Great Axe", 1, 12, WEAPON, AXE);
        Hero heroJim = new Mage("Jim");
        String expected = "Tried to equip invalid weapon";


        // Act & Assert
        InvalidWeaponException exception = assertThrows(InvalidWeaponException.class,
                () -> heroJim.equip(axe));
        String actual = exception.getMessage();
        assertEquals(expected, actual);

    }
}
