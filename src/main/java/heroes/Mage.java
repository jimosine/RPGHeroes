package heroes;

/* Imports */
import utilities.HeroAttribute;
import static items.Item.Slot.WEAPON;

/* In this child class of Hero, we define a Mage specific hero which is good with intelligence. The two abstract classes
 * levelUp() and damage() are overwritten as a mage gets experience in intelligence when leveling and this stat is used
 * for the damage calculations. A mage starts with 1 strength, 1 dexterity and 8 intelligence points and is able to equip
 * wands and staves as weapons, and cloth armor.
 *  */

public class Mage extends Hero {

    //Constructor for our mage. We use the name as provided by the user, and update the mage's stats and equipable items
    public Mage(String name) {
        super(name);
        this.levelAttributes = new HeroAttribute(1,1,8);

        //Add all valid item types
        validWeaponTypes.add("WAND");
        validWeaponTypes.add("STAFF");
        validArmorTypes.add("CLOTH");
    }

    //Override the abstract levelUp method in Hero. Whenever a mage gets to level up, we need to increase its level by
    //1 and increase its attributes by 1 strength, 1 dexterity and 5 intelligence points. For this we use the
    //increaseStats methods, which belongs to the HeroAttribute class.
    @Override
    public void levelUp() {
        setLevel(getLevel() + 1);
        //Get the current attributes
        HeroAttribute currentAttributes = getLevelAttributes();
        setAttributes(currentAttributes.increaseStats(1,1,5));

    }

    //Calculations for the damage output for a mage are dependent on the weapon it's wearing and its intelligence.
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

        //We need to retrieve the total intelligence (level + armor) and use this stat for our damage calculation
        double damagingAttribute = totalAttributes().getIntel();
        return weaponDmg * (1 + damagingAttribute / 100);
    }
}

