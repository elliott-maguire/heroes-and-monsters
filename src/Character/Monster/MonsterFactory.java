package Character.Monster;

import java.util.Random;

public class MonsterFactory {

    public static Monster createSkeleton() {
        return new Monster("Sargath the Skeleton", 100, 3, .8, .3, 30, 50, 30, 50, "slices his rusty blade at");
    }

    public static Monster createGremlin() {
        return new Monster("Gnarltooth the Gremlin", 70, 5, .8, .4, 15, 30, 20, 40, "jabs his kris at");
    }

    public static Monster createOgre() {
        return new Monster("Oscar the Ogre", 200, 2, .6, .1, 30, 50, 30, 50, "slowly swings a club toward's");
    }

    public static Monster createRandomMonster() {
        int random = (new Random()).nextInt();
        random = random%3;

        switch(random){
            case 0:
                return createSkeleton();
            case 1:
                return createOgre();
            default:
                return createGremlin();
        }
    }


}
