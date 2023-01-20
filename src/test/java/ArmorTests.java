import heroes.Hero;
import heroes.Mage;
import items.Armor;
import utilities.HeroAttribute;
import org.junit.jupiter.api.Test;
import utilities.InvalidArmorException;
import utilities.InvalidWeaponException;

import static items.Armor.ArmorType.*;
import static items.Item.Slot.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/* Here we do all the unit testing for the Armor item class and also test our custom exception messages. These occur
 * when a hero tries to equip armor which is not suitable for its class or when its level is too low. For these tests
 * we use a Mage object, but they pass for all classes.
* */
public class ArmorTests {

    //Test if the correct name is returned
    @Test
    void TestArmorName_ShouldPass() {
        HeroAttribute armorStats = new HeroAttribute(1,1,1);
        Armor helmet = new Armor("Iron Helmet", 1, armorStats, HEAD, PLATE);

        assertEquals("Iron Helmet", helmet.getName());
    }

    //Test if the correct level is returned
    @Test
    void TestArmorLevel_ShouldPass() {
        HeroAttribute armorStats = new HeroAttribute(1,1,1);
        Armor helmet = new Armor("Iron Helmet", 1, armorStats, HEAD, PLATE);

        assertEquals(1, helmet.getRequiredLevel());
    }

    //Test if the correct armor slot is returned
    @Test
    void TestArmorSlot_ShouldPass() {
        HeroAttribute armorStats = new HeroAttribute(1,1,1);
        Armor helmet = new Armor("Iron Helmet", 1, armorStats, HEAD, PLATE);

        assertEquals(HEAD, helmet.getSlot());
    }

    //Test if the correct armor type is returned
    @Test
    void TestArmorType_ShouldPass() {
        HeroAttribute armorStats = new HeroAttribute(1,1,1);
        Armor helmet = new Armor("Iron Helmet", 1, armorStats, HEAD, PLATE);

        assertEquals(PLATE, helmet.getArmorTypes());
    }

    //Test if the correct armor attributes are returned
    @Test
    void TestArmorAttributes_Str_ShouldPass() {
        HeroAttribute armorStats = new HeroAttribute(1,1,1);
        Armor helmet = new Armor("Iron Helmet", 1, armorStats, HEAD, PLATE);

        int expected = 1;
        assertEquals(expected, helmet.getArmorAttribute().getStr());
    }

    @Test
    void TestArmorAttributes_Dex_ShouldPass() {
        HeroAttribute armorStats = new HeroAttribute(1,1,1);
        Armor helmet = new Armor("Iron Helmet", 1, armorStats, HEAD, PLATE);

        int expected = 1;
        assertEquals(expected, helmet.getArmorAttribute().getDex());
    }

    @Test
    void TestArmorAttributes_Intel_ShouldPass() {
        HeroAttribute armorStats = new HeroAttribute(1,1,1);
        Armor helmet = new Armor("Iron Helmet", 1, armorStats, HEAD, PLATE);

        int expected = 1;
        assertEquals(expected, helmet.getArmorAttribute().getIntel());
    }


    //Test if the hero can correctly equip armor by equipping an hat and checking if the name is correct
    @Test
    void TestArmorEquip_ShouldPass() throws InvalidArmorException, InvalidWeaponException {
        HeroAttribute armorStats = new HeroAttribute(1,1,1);
        Armor hat = new Armor("Pointy Hat", 1, armorStats, HEAD, CLOTH);
        Hero heroJim = new Mage("Jim");

        heroJim.equip(hat);
        heroJim.getEquipment();
        assertEquals("Pointy Hat", hat.getName());
    }

    //Test our custom message when a hero tries to equip a piece of armor that is too high level
    @Test
    public void TestInvalidArmorException_LowLevel_ShouldThrowException() {
        HeroAttribute armorStats = new HeroAttribute(1,1,1);
        Armor hat = new Armor("Super Pointy Hat", 5, armorStats, HEAD, CLOTH);
        Hero heroJim = new Mage("Jim");
        String expected = "Your level it too low to equip this armor";


        InvalidArmorException exception = assertThrows(InvalidArmorException.class,
                () -> heroJim.equip(hat));
        String actual = exception.getMessage();
        assertEquals(expected, actual);

    }

    //Test our custom message when a hero tries to equip a piece of armor that is not suitable
    @Test
    public void TestInvalidArmorException_WrongType_ShouldThrowException(){
        HeroAttribute armorStats = new HeroAttribute(1,1,1);
        Armor helmet = new Armor("Iron Helmet", 1, armorStats, HEAD, PLATE);
        Hero heroJim = new Mage("Jim");
        String expected = "Tried to equip invalid armor";

        InvalidArmorException exception = assertThrows(InvalidArmorException.class,
                () -> heroJim.equip(helmet));
        String actual = exception.getMessage();
        assertEquals(expected, actual);

    }
}