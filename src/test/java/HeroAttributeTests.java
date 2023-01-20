
import utilities.HeroAttribute;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/* In this class we do all unit testing relating to the HeroAttributes class. We do basic tests to return the correct
*  strength, dexterity, intelligence. We also test the increaseStats() method, to see if we get the correct output */
public class HeroAttributeTests {

    //Test if the correct strength from a HeroAttribute gets returned
    @Test
    void TestReturnAttributes_Str_ShouldPass(){
        HeroAttribute testAttributes = new HeroAttribute(1,1,1);
        int expected = 1;
        assertEquals(expected, testAttributes.getStr());
    }

    //Test if the correct dexterity from a HeroAttribute gets returned
    @Test
    void TestReturnAttributes_Dex_ShouldPass(){
        HeroAttribute testAttributes = new HeroAttribute(1,1,1);
        int expected = 1;
        assertEquals(expected, testAttributes.getDex());
    }

    //Test if the correct intelligence from a HeroAttribute gets returned
    @Test
    void TestReturnAttributes_Intel_ShouldPass(){
        HeroAttribute testAttributes = new HeroAttribute(1,1,1);
        int expected = 1;
        assertEquals(expected, testAttributes.getIntel());
    }

    //Test if the correct strength from a HeroAttribute gets returned after increasing its number by 1
    @Test
    void TestIncreasingStats_Str_ShouldPass(){
        HeroAttribute testAttributes = new HeroAttribute(1,1,1);
        int expected = 2;
        assertEquals(expected, testAttributes.increaseStats(1, 1, 1).getStr());
    }

    //Test if the correct dexterity from a HeroAttribute gets returned after increasing its number by 1
    @Test
    void TestIncreasingStats_Dex_ShouldPass(){
        HeroAttribute testAttributes = new HeroAttribute(1,1,1);
        int expected = 2;
        assertEquals(expected, testAttributes.increaseStats(1, 1, 1).getDex());
    }

    //Test if the correct intelligence from a HeroAttribute gets returned after increasing its number by 1
    @Test
    void TestIncreasingStats_Intel_ShouldPass(){
        HeroAttribute testAttributes = new HeroAttribute(1,1,1);
        int expected = 2;
        assertEquals(expected, testAttributes.increaseStats(1, 1, 1).getIntel());
    }
}
