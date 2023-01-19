import heroes.Hero;
import utilities.HeroAttribute;
import heroes.Mage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MageCreationTests {


    @Test
    void nameChecker() {
        Hero heroJim = new Mage("Jim");

        assertEquals("Jim", heroJim.getName());
    }

    @Test
    void levelChecker() {
        Hero heroJim = new Mage("Jim");
        assertEquals(1, heroJim.getLevel());
    }

    @Test
    void attributesChecker() {
        Hero heroJim = new Mage("Jim");
        assertEquals(new HeroAttribute(1,1,8).getStr(), heroJim.getLevelAttributes().getStr());
        assertEquals(new HeroAttribute(1,1,8).getDex(), heroJim.getLevelAttributes().getDex());
        assertEquals(new HeroAttribute(1,1,8).getIntel(), heroJim.getLevelAttributes().getIntel());
    }
}
