package Character.Hero;

import Character.Character;

public class Sorceress extends Hero {
    private static final int MIN_ADD = 25;
    private static final int MAX_ADD = 50;

    public Sorceress() {
        super("Sorceress", 75, 5, .7, 25, 50, .3, "casts a spell of fireball at","Increase Hit Points");
    }


    @Override
    protected void altAttack(Character opponent){
        int hPoints;
        hPoints = (int) (Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
        addHitPoints(hPoints);
        System.out
                .println(name + " added [" + hPoints + "] points.\n" + "Total hit points remaining are: " + hitPoints);
        System.out.println();
    }



    //overriding battleChoices to implement special Sorceress conditions
    @Override
    public void battleChoices(Character opponent) {
        this.numberOfTurns(opponent);
        
        do {
            this.battleChoicesInput(opponent);
        } while (numTurns > 0 && hitPoints > 0 && opponent.getHitPoints() > 0);

    }

}
