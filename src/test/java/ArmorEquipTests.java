import org.example.*;
import org.junit.jupiter.api.Test;

import static org.example.Armor.ArmorType.*;
import static org.example.Item.Slot.*;

import static org.example.Weapon.WeaponTypes.AXE;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArmorEquipTests {

    //Test if the hero can correctly equip armor
    @Test
    void armorEquipChecker() throws InvalidArmorException, InvalidWeaponException {
        HeroAttribute armorStats = new HeroAttribute(1,1,1);
        Armor hat = new Armor("Pointy Hat", 1, armorStats, HEAD, CLOTH);
        Hero heroJim = new Mage("Jim");

        heroJim.equip(hat);
        heroJim.getEquipment();
        assertEquals("Pointy Hat", hat.getName());
    }

    @Test
    public void armorIllegalLevelChecker() {

        // Arrange
        HeroAttribute armorStats = new HeroAttribute(1,1,1);
        Armor hat = new Armor("Super Pointy Hat", 5, armorStats, HEAD, CLOTH);
        Hero heroJim = new Mage("Jim");
        String expected = "Tried to equip invalid armor";


        // Act & Assert
        InvalidArmorException exception = assertThrows(InvalidArmorException.class,
                () -> heroJim.equip(hat));
        String actual = exception.getMessage();
        assertEquals(expected, actual);

    }

    @Test
    public void armorIllegalTypeChecker(){

        // Arrange
        HeroAttribute armorStats = new HeroAttribute(1,1,1);
        Armor helmet = new Armor("Iron Helmet", 1, armorStats, HEAD, PLATE);
        Hero heroJim = new Mage("Jim");
        String expected = "Tried to equip invalid armor";


        // Act & Assert
        InvalidArmorException exception = assertThrows(InvalidArmorException.class,
                () -> heroJim.equip(helmet));
        String actual = exception.getMessage();
        assertEquals(expected, actual);

    }
}
