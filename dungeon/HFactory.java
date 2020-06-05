package dungeon;

import java.util.Random;

public enum HFactory{
    THEIF,
    WARRIOR,
    SORCERESS;

    private static Random random = new Random();

    public Hero make(){
        switch(this){

            case THEIF:
                return new Thief();
            case WARRIOR:
                return new Warrior();
            case SORCERESS:
                return new Sorceress();

        }

        return rand();
    }

    public static Hero rand(){
        HFactory[] heros = HFactory.values();
        return heros[ random.nextInt( heros.length ) ].make();
    }

}

