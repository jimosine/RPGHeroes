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

public class TotalAttributesTests {
    @Test
    public void noEquipmentAttributesTest(){
        Hero heroJim = new Mage("Jim");
        HeroAttribute total = heroJim.totalAttributes();
        assertEquals(new HeroAttribute(1,1,8).getStr(), total.getStr());
        assertEquals(new HeroAttribute(1,1,8).getDex(), total.getDex());
        assertEquals(new HeroAttribute(1,1,8).getIntel(), total.getIntel());
    }

    @Test
    public void oneArmorEquipmentAttributesTest() throws InvalidArmorException, InvalidWeaponException {
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

    @Test
    public void twoArmorEquipmentAttributesTest() throws InvalidArmorException, InvalidWeaponException {
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

    @Test
    public void replacedArmorEquipmentAttributesTest() throws InvalidArmorException, InvalidWeaponException {
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
