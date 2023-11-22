public class Shield {
    private int baseDef;
    private int def;
    private double spdDec;//speed decrease
    private boolean equip;
    private int ShieldLevel;

    Shield(int baseDef){
        this.baseDef = baseDef;
        equip = false;
        ShieldLevel = 1;
    }
    Shield(){
        this(1);
    }

    public void ShieldlevelUp(int lvl) {
        ShieldLevel += lvl;
        def = (int)(baseDef*(1+0.1*ShieldLevel));
    }

    public int getBaseDef(){
        return baseDef;
    }

    public void setDef(int def){
        this.def = def;
    }

    public int getDef(){
        return def;
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
    public int getLevel() {return ShieldLevel;}
    public void setLevel(int ShieldLevel) {this.ShieldLevel=ShieldLevel;}
}
