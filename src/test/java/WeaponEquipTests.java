import org.example.*;
import org.junit.jupiter.api.Test;

import static org.example.Item.Slot.*;
import static org.example.Weapon.WeaponTypes.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WeaponEquipTests {

    Weapon staff = new Weapon("Fire Staff", 1, 12, WEAPON, STAFF);
    private final Hero heroJim = new Mage("Jim");

    //!MISSCHIEN DUS TWEE SOORTEN EQUIPS MAKEN, DAN HOEF JE NIET BEIDE EXCEPTIONS TE THROWEN
    //Test if the hero can correctly equip weapons
    @Test
    void weaponEquipChecker() throws InvalidArmorException, InvalidWeaponException {
        heroJim.equip(staff);
        heroJim.getEquipment();
        assertEquals("Fire Staff", staff.getName());
    }

    @Test
    public void weaponIllegalLevelChecker() throws InvalidArmorException, InvalidWeaponException {

        // Arrange
        Weapon lavaStaff = new Weapon("Lava Staff", 5, 12, WEAPON, STAFF);
        Hero heroJim = new Mage("Jim");
        String expected = "Tried to equip invalid weapon";


//        // Act & Assert
        InvalidWeaponException exception = assertThrows(InvalidWeaponException.class,
                () -> heroJim.equip(lavaStaff));
        String actual = exception.getMessage();
        assertEquals(expected, actual);

    }

    @Test
    public void weaponIllegalTypeChecker() throws InvalidArmorException, InvalidWeaponException {

        // Arrange
        Weapon lavaStaff = new Weapon("Lava Staff", 1, 12, WEAPON, AXE);
        Hero heroJim = new Mage("Jim");
        String expected = "Tried to equip invalid weapon";


//        // Act & Assert
        InvalidWeaponException exception = assertThrows(InvalidWeaponException.class,
                () -> heroJim.equip(lavaStaff));
        String actual = exception.getMessage();
        assertEquals(expected, actual);

    }
}
