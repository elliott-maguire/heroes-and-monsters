package Character;

public abstract class Character {

    protected String name;
    protected int hitPoints;
    protected int attackSpeed;
    private double chanceToHit;
    private int damageMin, damageMax;
    private String attack1_print;

    public Character(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax, String attack1) {

        this.name = name;
        this.hitPoints = hitPoints;
        this.attackSpeed = attackSpeed;
        this.chanceToHit = chanceToHit;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
        this.attack1_print = attack1;

}

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void addHitPoints(int hitPoints) {
        if (hitPoints <= 0) {
            System.out.println("Hitpoint amount must be positive.");
        } else {
            this.hitPoints += hitPoints;
        }
    }

    public void subtractHitPoints(int hitPoints) {
        if (hitPoints < 0) {
            System.out.println("Hitpoint amount must be positive.");
        } else if (hitPoints > 0) {
            this.hitPoints -= hitPoints;
            if (this.hitPoints < 0) {
                this.hitPoints = 0;
            }
            System.out.println(getName() + " hit " + " for <" + hitPoints + "> points damage.");
            System.out.println(getName() + " now has " + getHitPoints() + " hit points remaining.\n");
        }
        if (this.hitPoints == 0) {
            System.out.println(name + " has been killed :-(");
        }
    }

    public boolean isAlive() {
        return (hitPoints > 0);
    }

    public void attack(Character opponent) {
        boolean canAttack;
        int damage;

        if(!this.attack1_print.isEmpty())
            System.out.println(this.name + " " + this.attack1_print + " " + opponent.getName() + ":");

        canAttack = Math.random() <= chanceToHit;
        if (canAttack) {
            damage = (int) (Math.random() * (damageMax - damageMin + 1)) + damageMin;
            opponent.subtractHitPoints(damage);
        } else {
            System.out.println(getName() + "'s attack on " + opponent.getName() + " failed!");
        }
    }
}