package heroes;

/* Imports */
import utilities.HeroAttribute;
import static items.Item.Slot.WEAPON;

/* In this child class of Hero, we define a Rogue specific hero which is good with dexterity. The two abstract classes
 * levelUp() and damage() are overwritten as a rogue gets experience in dexterity when leveling and this stat is used
 * for the damage calculations. A ranger starts with 2 strength, 6 dexterity and 1 intelligence points and is able to
 * equip daggers and swords as weapons, and leather & mail armor.
 *  */
public class Rogue extends Hero {


    //Constructor for our rogue. We use the name as provided by the user, and update the rogue's stats and equipable
    // items
    public Rogue(String name) {
        super(name);
        this.levelAttributes = new HeroAttribute(2,6,1);

        //Add all valid item types
        validWeaponTypes.add("DAGGER");
        validWeaponTypes.add("SWORD");
        validArmorTypes.add("LEATHER");
        validArmorTypes.add("MAIL");
    }

    //Override the abstract levelUp method in Hero. Whenever a rogue gets to level up, we need to increase its level by
    //1 and increase its attributes by 1 strength, 4 dexterity and 1 intelligence points. For this we use the
    //increaseStats methods, which belongs to the HeroAttribute class.
    @Override
    public void levelUp() {
        setLevel(getLevel() + 1);

        //get the current attributes
        HeroAttribute currentAttributes = getLevelAttributes();
        setAttributes(currentAttributes.increaseStats(1,4,1));

    }

    //Calculations for the damage output for a rogue are dependent on the weapon it's wearing and its dexterity.
    //We can encounter null values whenever a hero is not wearing weapons, which we need to account for.
    //If no weapons are equipped, we set the weaponDamage stat to 1, otherwise we retrieve it.
    @Override
    public double damage() throws NullPointerException {
        int weaponDmg = 1;

        //Try and retrieve the weapon damage by searching for the WEAPON key in our equipment HashMap
        try {
            weaponDmg = this.getEquipment().get(WEAPON).getWeaponDamage();
            //If not wearing a weapon (= null), return weapon damage as 1
            //If not wearing a weapon (= null), return default weapon damage
        } catch (NullPointerException e2){}

        //We need to retrieve the total dexterity (level + armor) and use this stat for our damage calculation
        double damagingAttribute = totalAttributes().getDex();
        return weaponDmg * (1 + damagingAttribute / 100);
    }

}

