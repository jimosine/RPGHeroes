import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.Hero;
import org.example.HeroAttribute;
import org.example.Mage;
import org.junit.jupiter.api.Test;
public class MageLevelingTests {

        private final Hero heroJim = new Mage("Jim");

        @Test
        void levelUpChecker() {
            heroJim.levelUp();
            assertEquals(2, heroJim.getLevel());
        }

        @Test //Opdelen in 1 assert per test
        void levelUpAttributesChecker() {
            heroJim.levelUp();
            assertEquals(new HeroAttribute(2,2,13).getStr(), heroJim.getLevelAttributes().getStr());
            assertEquals(new HeroAttribute(2,2,13).getDex(), heroJim.getLevelAttributes().getDex());
            assertEquals(new HeroAttribute(2,2,13).getIntel(), heroJim.getLevelAttributes().getIntel());
        }

        @Test
        void increasingStatsChecker(){
            //Check if we can correctly increase a Hero's attributes
            HeroAttribute stats = new HeroAttribute(1,1,1).increaseStats(1,1,1);
            HeroAttribute toCheck = new HeroAttribute(2, 2, 2);
            assertEquals(toCheck.getStr(), stats.getStr());
            assertEquals(toCheck.getDex(), stats.getDex());
            assertEquals(toCheck.getIntel(), stats.getIntel());
        }

}
