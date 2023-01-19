import heroes.Hero;
import utilities.HeroAttribute;
import heroes.Rogue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RogueCreationTests {


    @Test
    void nameChecker() {
        Hero heroJim = new Rogue("Jim");

        assertEquals("Jim", heroJim.getName());
    }

    @Test
    void levelChecker() {
        Hero heroJim = new Rogue("Jim");
        assertEquals(1, heroJim.getLevel());
    }

    @Test
    void attributesChecker() {
        Hero heroJim = new Rogue("Jim");
        assertEquals(new HeroAttribute(2,6,1).getStr(), heroJim.getLevelAttributes().getStr());
        assertEquals(new HeroAttribute(2,6,1).getDex(), heroJim.getLevelAttributes().getDex());
        assertEquals(new HeroAttribute(2,6,1).getIntel(), heroJim.getLevelAttributes().getIntel());
    }
}
