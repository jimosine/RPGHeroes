import org.example.Hero;
import org.example.HeroAttribute;
import org.example.Mage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MageCreationTests {
    private final Hero heroJim = new Mage("Jim");

    @Test
    void nameChecker() {
        assertEquals("Jim", heroJim.getName());
    }

    @Test
    void levelChecker() {
        assertEquals(1, heroJim.getLevel());
    }

    @Test
    void attributesChecker() {
        assertEquals(new HeroAttribute(1,1,5).getStr(), heroJim.getLevelAttributes().getStr());
        assertEquals(new HeroAttribute(1,1,5).getDex(), heroJim.getLevelAttributes().getDex());
        assertEquals(new HeroAttribute(1,1,8).getIntel(), heroJim.getLevelAttributes().getIntel());
    }
}
