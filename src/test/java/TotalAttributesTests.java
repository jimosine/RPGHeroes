import heroes.Hero;
import heroes.Mage;
import items.*;
import org.junit.jupiter.api.Test;
import utilities.HeroAttribute;
import utilities.InvalidArmorException;
import utilities.InvalidWeaponException;

import static items.Armor.ArmorType.CLOTH;
import static items.Item.Slot.BODY;
import static items.Item.Slot.HEAD;
import static org.junit.jupiter.api.Assertions.assertEquals;

/* In this class we do all unit testing relating to the Hero.totalAttributes() method. Tests are done on a Mage hero
* because Hero class is abstract. Testing for the other classes are redundant as if it works for Mage, should work for
*  every class. The tests are done with different ranges of armor equipped, and asserts are done for each HeroAttribute
*  stat together to not get this class bloated with separate tests. We expect the totals to be equal to the hero's
*  attributes combined with the armor attributes. For these tests we use a Mage object, but they pass for all classes */

public class TotalAttributesTests {

    //Test if the correct total attributes are return when no armor is equipped.
    @Test
    public void TestTotalAttributes_NoArmor_ShouldPass(){
        Hero heroJim = new Mage("Jim");
        HeroAttribute total = heroJim.totalAttributes();
        assertEquals(new HeroAttribute(1,1,8).getStr(), total.getStr());
        assertEquals(new HeroAttribute(1,1,8).getDex(), total.getDex());
        assertEquals(new HeroAttribute(1,1,8).getIntel(), total.getIntel());
    }

    //Test if the correct total attributes are return when a basic hat is equipped.
    @Test
    public void TestTotalAttributes_OneArmor_ShouldPass() throws InvalidArmorException, InvalidWeaponException {
        Hero heroJim = new Mage("Jim");
        HeroAttribute armorStats = new HeroAttribute(1,1,1);
        Armor hat = new Armor("Pointy Hat", 1, armorStats, HEAD, CLOTH);
        HeroAttribute expected = new HeroAttribute(2, 2, 9);

        heroJim.equip(hat);
        HeroAttribute total = heroJim.totalAttributes();
        assertEquals(expected.getStr(), total.getStr());
        assertEquals(expected.getDex(), total.getDex());
        assertEquals(expected.getIntel(), total.getIntel());
    }

    //Test if the correct total attributes are return when a hat and a robe are equipped.
    @Test
    public void TestTotalAttributes_TwoArmor_ShouldPass() throws InvalidArmorException, InvalidWeaponException {
        Hero heroJim = new Mage("Jim");
        HeroAttribute armorStats = new HeroAttribute(1,1,1);
        Armor hat = new Armor("Pointy Hat", 1, armorStats, HEAD, CLOTH);
        Armor robe = new Armor("Wizard Robe", 1, armorStats, BODY, CLOTH);
        HeroAttribute expected = new HeroAttribute(3, 3, 10);

        heroJim.equip(hat);
        heroJim.equip(robe);
        HeroAttribute total = heroJim.totalAttributes();
        assertEquals(expected.getStr(), total.getStr());
        assertEquals(expected.getDex(), total.getDex());
        assertEquals(expected.getIntel(), total.getIntel());
    }

    //Test if the correct total attributes are return when full armor is equipped.
    @Test
    public void TestTotalAttributes_ReplacedArmor_ShouldPass() throws InvalidArmorException, InvalidWeaponException {
        Hero heroJim = new Mage("Jim");
        HeroAttribute armorStats = new HeroAttribute(1,1,1);
        Armor hat = new Armor("Pointy Hat", 1, armorStats, HEAD, CLOTH);
        Armor robe = new Armor("Wizard Robe", 1, armorStats, BODY, CLOTH);
        Armor mask = new Armor("Magic Mask", 1, armorStats, HEAD, CLOTH);
        HeroAttribute expected = new HeroAttribute(3, 3, 10);

        heroJim.equip(hat);
        heroJim.equip(robe);
        heroJim.equip(mask);
        HeroAttribute total = heroJim.totalAttributes();
        assertEquals(expected.getStr(), total.getStr());
        assertEquals(expected.getDex(), total.getDex());
        assertEquals(expected.getIntel(), total.getIntel());
    }


}
