package adventure.Character.Monster;

import adventure.Action.ActionIndex;
import adventure.Meta.MetaIndex;

import java.util.Random;

public class MonsterFactory {
    public static Monster makeOgre() {
        return new Ogre(MetaIndex.getOgreMeta(), ActionIndex.getStrikeAction(), ActionIndex.getQuickStrikeAction());
    }

    public static Monster makeSkeleton() {
        return new Skeleton(MetaIndex.getSkeletonMeta(), ActionIndex.getStrikeAction(),
                ActionIndex.getQuickStrikeAction());
    }

    public static Monster makeSpider() {
        return new Spider(MetaIndex.getSpiderMeta(), ActionIndex.getStrikeAction(), ActionIndex.getQuickStrikeAction());
    }

    public static Monster makeWitch() {
        return new Witch(MetaIndex.getWitchMeta(), ActionIndex.getStrikeAction(), ActionIndex.getQuickStrikeAction());
    }

    public static Monster makeZombie() {
        return new Zombie(MetaIndex.getZombieMeta(), ActionIndex.getStrikeAction(), ActionIndex.getQuickStrikeAction());
    }

    public static Monster makeRandom(){
        Random rand = new Random();
        int i = rand.nextInt(5);

        switch(i){
            case 0:
                return makeOgre();
            case 1:
                return makeSkeleton();
            case 2:
                return makeSpider();
            case 3:
                return makeWitch();

        }

        return makeZombie();
    }
}
