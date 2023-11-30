public class Lab03 {

    public static void main(String[] args){
        Character c = new Character("Rimuru", 1);

        c.equipSword(false);
        c.equipShield(false);
        c.showStats();
        c.equipSword(true);
        c.showStats();
        c.equipShield(true);
        c.showStats();

        c.levelUp(45);
        c.SwordlevelUp(48);
        c.ShieldlevelUp(45);

        c.equipSword(false);
        c.equipShield(false);
        c.showStats();
        c.equipSword(true);
        c.showStats();
        c.equipShield(true);
        c.showStats();
//        Character d = new Character("Clayman", 1);
//        c.levelUp(53);
//        c.levelUp();
//        d.levelUp(42);
//        d.showStats();
//        c.showStats();
//        c.equipSword(true);
//        d.equipShield(true);
//        d.showStats();
//        c.showStats();
//        c.SwordlevelUp(50);
//        c.showStats();
//        d.ShieldlevelUp(37);
//        d.showStats();
//        c.attack(d);
//        c.attack(d);
//        d.showStats();
//        c.showStats();
    }
}
