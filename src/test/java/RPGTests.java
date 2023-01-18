import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.Mage;
import org.junit.jupiter.api.Test;
public class RPGTests {


    static class HeroTests {

        private final Mage heroJim = new Mage("Jim");

        @Test
        void nameChecker() {
            assertEquals("Jim", heroJim.getName());
        }

    }

    static class MageTests {

        private final Mage heroJim = new Mage("Jim");

        @Test
        void levelUpChecker() {
            heroJim.levelUp();
            assertEquals(2, heroJim.getLevel());
        }

    }
}
