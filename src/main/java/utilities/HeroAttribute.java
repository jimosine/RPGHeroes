package utilities;

public class HeroAttribute {
    public int str;
    public int dex;
    public int intel;

    public HeroAttribute(int str, int dex, int intel){
       this.str = str;
       this.dex = dex;
       this.intel = intel;
    }

    public HeroAttribute increaseStats(int str, int dex, int intel){
        setStr(str + getStr());
        setDex(dex + getDex());
        setIntel(intel + getIntel());
        return new HeroAttribute(this.str, this.dex, this.intel);
    }

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
