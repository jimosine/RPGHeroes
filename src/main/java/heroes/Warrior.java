package heroes;

/* Imports */
import utilities.HeroAttribute;
import static items.Item.Slot.WEAPON;

/* In this child class of Hero, we define a Warrior specific hero which is good with dexterity. The two abstract classes
 * levelUp() and damage() are overwritten as a warrior gets experience in strength when leveling and this stat is used
 * for the damage calculations. A warrior starts with 5 strength, 2 dexterity and 1 intelligence points and is able to
 * equip axes, swords, hammers as weapons, and mail & plate armor.
 *  */
public class Warrior extends Hero {

    //Constructor for our warrior. We use the name as provided by the user, and update the warrior's stats and equipable
    // items
    public Warrior(String name) {
        super(name);
        this.levelAttributes = new HeroAttribute(5,2,1);

        //Add all valid item types
        validWeaponTypes.add("AXE");
        validWeaponTypes.add("SWORD");
        validWeaponTypes.add("HAMMER");
        validArmorTypes.add("MAIL");
        validArmorTypes.add("PLATE");
    }

    //Override the abstract levelUp method in Hero. Whenever a warrior gets to level up, we need to increase its level
    //by 1 and increase its attributes by 3 strength, 2 dexterity and 1 intelligence points. For this we use the
    //increaseStats methods, which belongs to the HeroAttribute class.
    @Override
    public void levelUp() {
        setLevel(getLevel() + 1);

        //get the current attributes
        HeroAttribute currentAttributes = getLevelAttributes();
        setAttributes(currentAttributes.increaseStats(3,2,1));

    }

    //Calculations for the damage output for a warrior are dependent on the weapon it's wearing and its strength.
    //We can encounter null values whenever a hero is not wearing weapons, which we need to account for.
    //If no weapons are equipped, we set the weaponDamage stat to 1, otherwise we retrieve it.
    @Override
    public double damage() throws NullPointerException {
        int weaponDmg = 1;

        //Try and retrieve the weapon damage by searching for the WEAPON key in our equipment HashMap
        try {
            weaponDmg = this.getEquipment().get(WEAPON).getWeaponDamage();
            //If not wearing a weapon (= null), return weapon damage as 1
        } catch (NullPointerException e2){
            weaponDmg = 1;
        }

        //We need to retrieve the total strength (level + armor) and use this stat for our damage calculation
        double damagingAttribute = totalAttributes().getStr();
        return weaponDmg * (1 + damagingAttribute / 100);
    }

}

