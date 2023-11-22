public class Sword {
    private int baseDmg;
    private int Dmg;
    private double spdDec;
    private boolean equip;
    private int SwordLevel;
    Character cha;

    Sword(int baseDmg){
        this.baseDmg = baseDmg;
        equip = false;
        SwordLevel = 1;
    }
    Sword(){
        this(2);
    }


    public void setDmg(int dmg){
        Dmg = dmg;
    }
    public int getDmg(){
        return Dmg;
    }

    public int getBaseDmg(){
        return baseDmg;
    }

    public double getSpdDec() {
        return spdDec;
    }
    public void setSpdDec(double spdDec) {
        this.spdDec = spdDec;
    }

    public boolean isEquip() {
        return equip;
    }
    public void setEquip(boolean equip) {
        this.equip = equip;
    }
    public int getLevel() {return SwordLevel;}
    public void setLevel(int SwordLevel) {this.SwordLevel=SwordLevel;}
}
