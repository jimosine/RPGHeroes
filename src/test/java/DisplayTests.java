import org.example.Hero;
import org.example.Mage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisplayTests {
    @Test
    public void correctNameTest(){
        Hero heroJim = new Mage("Jim");
        String expected = "Jim";
        String actual = heroJim.displayStats().substring(0, 3);
        assertEquals(expected,actual);
    }

    @Test
    public void correctClassTest(){
        Hero heroJim = new Mage("Jim");
        String expected = "Mage";
        String actual = heroJim.displayStats().substring(3, 7);
        assertEquals(expected,actual);
    }

    @Test
    public void correctLevelTest(){
        Hero heroJim = new Mage("Jim");
        String expected = "2";
        String actual = heroJim.displayStats().substring(7, 8);
        assertEquals(expected,actual);
    }

    @Test
    public void correctStrengthTest(){
        Hero heroJim = new Mage("Jim");
        String expected = "1";
        String actual = heroJim.displayStats().substring(8, 9);
        assertEquals(expected,actual);
    }

    @Test
    public void correctDexterityTest(){
        Hero heroJim = new Mage("Jim");
        String expected = "1";
        String actual = heroJim.displayStats().substring(9, 10);
        assertEquals(expected,actual);
    }

    @Test
    public void correctIntelligenceTest(){
        Hero heroJim = new Mage("Jim");
        String expected = "8";
        String actual = heroJim.displayStats().substring(10, 11);
        assertEquals(expected,actual);
    }

    @Test
    public void correctDamageTest(){
        Hero heroJim = new Mage("Jim");
        String expected = "1.08";
        String actual = heroJim.displayStats().substring(11, 15);
        assertEquals(expected,actual);
    }
}
