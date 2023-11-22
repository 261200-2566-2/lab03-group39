public class Character {
    private String name; //The name of the character
    private boolean alive; //Character still alive or not?
    private int level; //Present Level of Character
    private int maxHp; //Max Hp of Character
    private int hp; // Hp of Character
    private int maxMana; // maxMana of Character
    private int mana; // Mana of Character
    private int baseDmg; // The Base damage of the Character
    private int damage; //the real damage that the player do
    private int baseDef;// The Base defense of the Character
    private int defense;//the real defense that the player have
    private double baseRunSpd;//The Base Runspeed of the Character
    private double runSpd;//the real Runspeed that the player have
    Sword sword;
    Shield shield;

    Character(String name, double baseSpd) {
        this.name = new String(name);
        alive = true;
        level = 1;
        maxHp = 100 + (10 * level);
        hp = maxHp;
        maxMana = 50 + (2 * level);
        mana = maxMana;
        baseDmg = 1;
        damage = baseDmg;
        baseDef = 0;
        defense = baseDef;
        baseRunSpd = baseSpd;

        sword = new Sword(5);
        shield = new Shield(3);

        setDamage();
        setDefense();
        setSpeed();
    }

    private void setDamage() {
        baseDmg = (int) Math.floor(1 + (0.05 * level));
        sword.setDmg((int) Math.floor(sword.getBaseDmg() * (1 + (0.1 * sword.getLevel()))));
        if (sword.isEquip())
            damage = baseDmg + sword.getDmg();
        else
            damage = baseDmg;
    }

    private void setDefense() {
        baseDef = (int) Math.floor(0 + (0.02 * level));
        shield.setDef((int) Math.floor(shield.getBaseDef() * (1 + (0.05 * shield.getLevel()))));
        if (shield.isEquip())
            defense = baseDef + shield.getDef();
        else
            defense = baseDef;
    }

    private void setSpeed() {
        runSpd = baseRunSpd * (1 + (0.03 * level));

        double swordSpdFac = 4 + sword.getLevel() - level; //our level must be higher than sword level by at least 4 to not get speed increase
        double shieldSpdFac = 6 + shield.getLevel() - level; //our level must be higher than shield level by at least 6 to not get speed increase
        if (swordSpdFac < 0) swordSpdFac = 0;
        if (shieldSpdFac < 0) shieldSpdFac = 0;
        sword.setSpdDec(0.02 * swordSpdFac);
        shield.setSpdDec(0.03 * shieldSpdFac);

        if (sword.isEquip())
            runSpd -= sword.getSpdDec();
        if (shield.isEquip())
            runSpd -= shield.getSpdDec();

        if (runSpd < 0.1)
            runSpd = 0.1;
    }

    public void SwordlevelUp(int lvl) {
        sword.setLevel(lvl + sword.getLevel());
        setDamage();
        setSpeed();
    }

    public void ShieldlevelUp(int lvl) {
        shield.setLevel(lvl + shield.getLevel());
        setDefense();
        setSpeed();
    }

    public void showStats() { //show the character current status
        System.out.println("Name: " + name);
        System.out.println("Lvl: " + level);
        System.out.println("HP: " + hp + "/" + maxHp);
        System.out.println("Mana: " + mana + "/" + maxMana);
        System.out.println("Speed: " + String.format("%.2f", runSpd));
        System.out.println("Damage:" + damage);
        System.out.println("Defense: " + defense);
        System.out.println("Sword Equipped: " + sword.isEquip());
        if(sword.isEquip())System.out.println("Sword Level: " + sword.getLevel());
        System.out.println("Shield Equipped: " + shield.isEquip());
        if(shield.isEquip())System.out.println("Shield Level: " + shield.getLevel());

        System.out.println("==============");
    }

    public void levelUp(int lvl) { //level up the character by lvl
        level += lvl;

        maxHp = 100 + (10 * level);
        hp = maxHp;
        maxMana = 50 + (2 * level);
        mana = maxMana;
        runSpd = baseRunSpd * (1 + (0.03 * level));

        setDamage();
        setDefense();
        setSpeed();
    }

    public void levelUp() { //level up the character by 1
        level += 1;

        maxHp = 100 + (10 * level);
        hp = maxHp;
        maxMana = 50 + (2 * level);
        mana = maxMana;
        runSpd = baseRunSpd * (1 + (0.03 * level));

        setDamage();
        setDefense();
        setSpeed();
    }

    public void equipSword(boolean b) { //choose to equip the sword or not
        sword.setEquip(b);
        setDamage();
        setSpeed();
    }

    public void equipShield(boolean b) { //choose to equip the shield or not
        shield.setEquip(b);
        setDefense();
        setSpeed();
    }

    public void attack(Character c) { //attack the target character (damage taken are calculated by the character's damage subtract by target character's defense )
        if (!c.getAlive()) {
            System.out.println(c.getName() + " is already Ded...");
            return;
        }

        int dmgDone = damage - c.getDefense();
        if (dmgDone < 0)
            dmgDone = 0;

        if (c.getHp() <= dmgDone) {
            c.setHp(0);
            c.setAlive(false);
            System.out.println("Eliminated " + c.getName() + " out of Existence.");
            return;
        } else {
            c.setHp(c.getHp() - dmgDone);
            System.out.println(
                    "Deal " + dmgDone + " to " + c.getName() + ", " + c.getName() + " has " + c.getHp() + " health remaining.");
        }
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public boolean getAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public double getRunSpd() {
        return runSpd;
    }

    public int getLevel() {
        return level;
    }

    public int getMana() {
        return mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public int getDefense() {
        return defense;
    }
}
