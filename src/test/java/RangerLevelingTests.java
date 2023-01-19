import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.Hero;
import org.example.HeroAttribute;
import org.example.Ranger;
import org.junit.jupiter.api.Test;
public class RangerLevelingTests {

    @Test
    void levelUpChecker() {
        Hero heroJim = new Ranger("Jim");
        heroJim.levelUp();
        assertEquals(2, heroJim.getLevel());
    }

    @Test //Opdelen in 1 assert per test
    void levelUpAttributesChecker() {
        Hero heroJim = new Ranger("Jim");
        heroJim.levelUp();
        assertEquals(new HeroAttribute(2,12,2).getStr(), heroJim.getLevelAttributes().getStr());
        assertEquals(new HeroAttribute(2,12,2).getDex(), heroJim.getLevelAttributes().getDex());
        assertEquals(new HeroAttribute(2,12,2).getIntel(), heroJim.getLevelAttributes().getIntel());
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
