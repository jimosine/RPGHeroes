import heroes.Hero;
import utilities.HeroAttribute;
import heroes.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarriorCreationTests {


    @Test
    void nameChecker() {
        Hero heroJim = new Warrior("Jim");

        assertEquals("Jim", heroJim.getName());
    }

    @Test
    void levelChecker() {
        Hero heroJim = new Warrior("Jim");
        assertEquals(1, heroJim.getLevel());
    }

    @Test
    void attributesChecker() {
        Hero heroJim = new Warrior("Jim");
        assertEquals(new HeroAttribute(5,2,1).getStr(), heroJim.getLevelAttributes().getStr());
        assertEquals(new HeroAttribute(5,2,1).getDex(), heroJim.getLevelAttributes().getDex());
        assertEquals(new HeroAttribute(5,2,1).getIntel(), heroJim.getLevelAttributes().getIntel());
    }
}
