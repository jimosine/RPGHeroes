import heroes.Hero;
import utilities.HeroAttribute;
import heroes.Ranger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RangerCreationTests {


    @Test
    void nameChecker() {
        Hero heroJim = new Ranger("Jim");

        assertEquals("Jim", heroJim.getName());
    }

    @Test
    void levelChecker() {
        Hero heroJim = new Ranger("Jim");
        assertEquals(1, heroJim.getLevel());
    }

    @Test
    void attributesChecker() {
        Hero heroJim = new Ranger("Jim");
        assertEquals(new HeroAttribute(1,7,1).getStr(), heroJim.getLevelAttributes().getStr());
        assertEquals(new HeroAttribute(1,7,1).getDex(), heroJim.getLevelAttributes().getDex());
        assertEquals(new HeroAttribute(1,7,1).getIntel(), heroJim.getLevelAttributes().getIntel());
    }
}
