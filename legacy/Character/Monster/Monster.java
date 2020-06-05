package Character.Monster;

import Character.Character;

public class Monster extends Character {
    private double chanceToHeal;
    private int minHeal, maxHeal;

    protected Monster(String name, int hitPoints, int attackSpeed, double chanceToHit, double chanceToHeal, int damageMin, int damageMax,int minHeal, int maxHeal, String attack1) {
        super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, attack1);
        this.chanceToHeal = chanceToHeal;
        this.maxHeal = maxHeal;
        this.minHeal = minHeal;
    }

    private void heal() {
        boolean canHeal;
        int healPoints;

        canHeal = (Math.random() <= chanceToHeal) && (hitPoints > 0);
        if (canHeal) {
            healPoints = (int) (Math.random() * (maxHeal - minHeal + 1)) + minHeal;
            addHitPoints(healPoints);
            System.out.println(name + " healed itself for " + healPoints + " points.\n"
                    + "Total hit points remaining are: " + hitPoints);
            System.out.println();
        }
    }

    public void subtractHitPoints(int hitPoints) {
        super.subtractHitPoints(hitPoints);
        heal();
    }
}