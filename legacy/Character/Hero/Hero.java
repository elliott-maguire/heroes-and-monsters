
package Character.Hero;

import Character.Character;
import Core.Keyboard;

public abstract class Hero extends Character {
    protected int numTurns;
    private double chanceToBlock;
    private String altAttack_print;


    protected Hero(String name, int hitPoints, int attackSpeed, double chanceToHit, int damageMin, int damageMax, double chanceToBlock, String attack1, String attack2) {
        super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, attack1);
        this.chanceToBlock = chanceToBlock;
        this.altAttack_print = attack2;
        readName();
    }

    private void readName() {
        Keyboard.readString();
        System.out.print("Enter character name: ");
        name = Keyboard.readString();
    }

    private boolean defend() {
        return Math.random() <= chanceToBlock;
    }

    protected abstract void altAttack(Character opponent);

    public void subtractHitPoints(int hitPoints) {
        if (defend()) {
            System.out.println(name + " BLOCKED the attack!");
        } else {
            super.subtractHitPoints(hitPoints);
        }
    }

    protected void numberOfTurns(Character opponent){
        numTurns = attackSpeed / opponent.getAttackSpeed();
        if (numTurns == 0)
            numTurns++;

        System.out.println("Number of turns this round is: " + numTurns);
    }

    protected void battleChoicesInput(Character opponent){
        int choice;

        System.out.println("1. Attack Opponent");
        System.out.println("2. " + altAttack_print);
        System.out.print("Choose an option: ");
        choice = Keyboard.readInt();

        switch (choice) {
            case 1:
                attack(opponent);
                break;
            case 2:
                altAttack(opponent);
                break;
            default:
                System.out.println("invalid choice!");
        }

        numTurns--;
        if (numTurns > 0)
            System.out.println("Number of turns remaining is: " + numTurns);

       
    }

    //default battleChoices behavior
    public void battleChoices(Character opponent) {
        numberOfTurns(opponent);
        do{
            battleChoicesInput(opponent);
        }while(numTurns > 0);
    }

}
