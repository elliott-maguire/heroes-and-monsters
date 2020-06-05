package dungeon;

import java.util.Random;

public enum MFactory {
    OGRE,
    SKELETON,
    GREMLIN;

    private static Random random = new Random();

    public Monster make(){
        switch(this){
            case OGRE:
                return new Monster("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50, "slowly swings a club toward's");
            case SKELETON:
                return new Monster("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50, "slices his rusty blade at");
            case GREMLIN:
                return new Monster("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40,"jabs his kris at");
        }

        return rand();
    }

    //returns random monster
    public static Monster rand(){
        MFactory[] mon = MFactory.values();
        return mon[random.nextInt(mon.length)].make();
    }

}

