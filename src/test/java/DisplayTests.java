import heroes.Hero;
import heroes.Mage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/* In this class we do all unit testing relating to the Hero.display() method. We do tests for the correct name
 * hero class, level, strength, dexterity, intelligence and damage. The display() method return a string which
 * concats all these features, there we simply check if our actual matches the corresponding substring of same length.
 * For these tests we use a Mage object, but they pass for all classes. */

public class DisplayTests {

    //Test if we correctly display the hero's name
    @Test
    public void TestDisplayCorrect_Name_ShouldPass(){
        Hero heroJim = new Mage("Jim");
        String expected = "Jim";
        String actual = heroJim.displayStats().substring(0, 3);
        assertEquals(expected,actual);
    }

    //Test if we correctly display the hero's class
    @Test
    public void TestDisplayCorrect_Class_ShouldPass(){
        Hero heroJim = new Mage("Jim");
        String expected = "Mage";
        String actual = heroJim.displayStats().substring(3, 7);
        assertEquals(expected,actual);
    }

    //Test if we correctly display the hero's level
    @Test
    public void TestDisplayCorrect_Level_ShouldPass(){
        Hero heroJim = new Mage("Jim");
        String expected = "1";
        String actual = heroJim.displayStats().substring(7, 8);
        assertEquals(expected,actual);
    }

    //Test if we correctly display the hero's strength
    @Test
    public void TestDisplayCorrect_Str_ShouldPass(){
        Hero heroJim = new Mage("Jim");
        String expected = "1";
        String actual = heroJim.displayStats().substring(8, 9);
        assertEquals(expected,actual);
    }

    //Test if we correctly display the hero's dexterity
    @Test
    public void TestDisplayCorrect_Dex_ShouldPass(){
        Hero heroJim = new Mage("Jim");
        String expected = "1";
        String actual = heroJim.displayStats().substring(9, 10);
        assertEquals(expected,actual);
    }

    //Test if we correctly display the hero's intelligence
    @Test
    public void TestDisplayCorrect_Intel_ShouldPass(){
        Hero heroJim = new Mage("Jim");
        String expected = "8";
        String actual = heroJim.displayStats().substring(10, 11);
        assertEquals(expected,actual);
    }

    //Test if we correctly display the hero's damage
    @Test
    public void TestDisplayCorrect_Damage_ShouldPass(){
        Hero heroJim = new Mage("Jim");
        String expected = "1.08";
        String actual = heroJim.displayStats().substring(11, 15);
        assertEquals(expected,actual);
    }
}
