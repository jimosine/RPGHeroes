import heroes.Hero;
import heroes.Warrior;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/* In this class we can find all the unit tests relating to the creation of a Warrior hero. Because the Hero class
 *  itself is abstract we can not create a new Hero object to run our tests on. Thus, we create a Hero object through
 *  the Warrior constructor.
 *  */
public class WarriorTests {

    //When a hero is created, do we return the correct name? For this we test the getName() method)
    //We expect getName() to return the same string as our argument when creating.
    @Test
    void TestCreateWarrior_Name_ShouldPass() {
        Hero heroJim = new Warrior("Jim");
        assertEquals("Jim", heroJim.getName());
    }

    //When a hero is created, do we return the correct level? For this we test the getLevel() method)
    //We expect getLevel() to return 1.
    @Test
    void TestCreateWarrior_Level_ShouldPass() {
        Hero heroJim = new Warrior("Jim");
        assertEquals(1, heroJim.getLevel());
    }

    //When a hero is created, do we return the correct attributes? For this we test the getLevelAttributes() method and
    //the getStr() method. We expect methods to return 1
    @Test
    void TestCreateWarrior_AttributesStr_ShouldPass() {
        Hero heroJim = new Warrior("Jim");
        int expected = 5;
        assertEquals(expected, heroJim.getLevelAttributes().getStr());

    }

    //When a hero is created, do we return the correct attributes? For this we test the getLevelAttributes() method and
    //the getDex() method. We expect methods to return 1
    @Test
    void TestCreateWarrior_AttributesDex_ShouldPass() {
        Hero heroJim = new Warrior("Jim");
        int expected = 2;
        assertEquals(expected, heroJim.getLevelAttributes().getDex());

    }

    //When a hero is created, do we return the correct attributes? For this we test the getLevelAttributes() method and
    //the getStr() method. We expect methods to return 8
    @Test
    void TestCreateWarrior_AttributesIntel_ShouldPass() {
        Hero heroJim = new Warrior("Jim");
        int expected = 1;
        assertEquals(expected, heroJim.getLevelAttributes().getIntel());
    }

    //When a warrior levels up, do we return the correct level? For this we test the levelUp() method. We expect the
    //hero's level to be 2 after 1 levelUp()
    @Test
    void TestLevelupWarrior_Level_ShouldPass() {
        Hero heroJim = new Warrior("Jim");
        heroJim.levelUp();
        assertEquals(2, heroJim.getLevel());
    }

    //When a warrior levels up, do we return the correct attributes? For this we test the levelUp() method. We expect the
    //hero's strength to be 2 after 1 levelUp()
    @Test
    void TestLevelupWarrior_AttributesStr_ShouldPass() {
        Hero heroJim = new Warrior("Jim");
        heroJim.levelUp();
        int expected = 8;
        assertEquals(expected, heroJim.getLevelAttributes().getStr());
    }

    //When a warrior levels up, do we return the correct attributes? For this we test the levelUp() method. We expect the
    //hero's dexterity to be 2 after 1 levelUp()
    @Test
    void TestLevelupWarrior_AttributesDex_ShouldPass() {
        Hero heroJim = new Warrior("Jim");
        heroJim.levelUp();
        int expected = 4;
        assertEquals(expected, heroJim.getLevelAttributes().getDex());
    }

    //When a warrior levels up, do we return the correct attributes? For this we test the levelUp() method. We expect the
    //hero's intelligence to be 13 after 1 levelUp()
    @Test
    void TestLevelupWarrior_AttributesIntel_ShouldPass() {
        Hero heroJim = new Warrior("Jim");
        heroJim.levelUp();
        int expected = 2;
        assertEquals(expected, heroJim.getLevelAttributes().getIntel());
    }

}
