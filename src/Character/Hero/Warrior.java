package Character.Hero;

import Character.Character;

public class Warrior extends Hero {

    Warrior() {
        super("Warrior", 125, 4, .8, 35, 60, .2, "swings a mighty sword at", "Crushing Blow on Opponent");
    }


    protected void altAttack(Character opponent){
        if (Math.random() <= .4) {
            int blowPoints = (int) (Math.random() * 76) + 100;
            System.out.println(name + " lands a CRUSHING BLOW for " + blowPoints + " damage!");
            opponent.subtractHitPoints(blowPoints);
        } else {
            System.out.println(name + " failed to land a crushing blow");
            System.out.println();
        }//blow failed
    }

}
