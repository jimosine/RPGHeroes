package utilities;

/* This class is responsible for creating stats to be used in the Hero classes and Armor item classes. A HeroAttribute
 * object is defined through 3 stats: strength, dexterity and intelligence. HeroAttribute objects also have the method
 * to increase stats, which happens when a hero levels up.
 *  */

//Define fields
public class HeroAttribute {
    public int str;
    public int dex;
    public int intel;

    //To create a HeroAttribute object, we need to put in a number for the strength, dexterity and intelligence
    public HeroAttribute(int str, int dex, int intel){
       this.str = str;
       this.dex = dex;
       this.intel = intel;
    }

    //To increase a hero's stats, we simply retrieve the current attributes, and add up the attributes the user puts in
    //This is then set as the hero's new attributes
    public HeroAttribute increaseStats(int str, int dex, int intel){
        setStr(str + getStr());
        setDex(dex + getDex());
        setIntel(intel + getIntel());
        return new HeroAttribute(this.str, this.dex, this.intel);
    }

    //Getters and setters
    public void setStr(int strength){
        str = strength;
    }

    public int getStr(){
        return str;
    }

    public void setDex(int dexterity){
        dex = dexterity;
    }

    public int getDex(){
        return dex;
    }

    public void setIntel(int intelligence){
        intel = intelligence;
    }

    public int getIntel(){
        return intel;
    }
}
