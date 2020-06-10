package adventure.Character.Monster;

import adventure.Action.ActionIndex;
import adventure.Meta.MetaIndex;

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
}
