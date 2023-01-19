import items.Armor;
import utilities.HeroAttribute;
import org.junit.jupiter.api.Test;

import static items.Armor.ArmorType.*;
import static items.Item.Slot.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArmorCreationTests {

    //Define some attributes that belong to our armor piece
    HeroAttribute armorStats = new HeroAttribute(1,1,1);
    //Create a new instance of a Plate Helmet called Iron Helmet with a level requirement of 1
    Armor helmet = new Armor("Iron Helmet", 1, armorStats, HEAD, PLATE);

    //Test if the correct name is returned
    @Test
    void armorNameChecker() {
        assertEquals("Iron Helmet", helmet.getName());
    }

    //Test if the correct level is returned
    @Test
    void armorLevelChecker() {
        assertEquals(1, helmet.getRequiredLevel());
    }

    //Test if the correct armor slot is returned
    @Test
    void armorSlotChecker() {
        assertEquals(HEAD, helmet.getSlot());
    }

    //Test if the correct armor type is returned
    @Test
    void armorTypeChecker() {
        assertEquals(PLATE, helmet.getArmorTypes());
    }

    //Test if the correct armor attributes are returned
    @Test
    void armorAttributesChecker() {
        HeroAttribute testAttributes = new HeroAttribute(1, 1, 1);
        assertEquals(testAttributes.getStr(), helmet.getArmorAttribute().getStr());
        assertEquals(testAttributes.getDex(), helmet.getArmorAttribute().getDex());
        assertEquals(testAttributes.getIntel(), helmet.getArmorAttribute().getIntel());
    }
}