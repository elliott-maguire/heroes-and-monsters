package adventure.Meta;

public class MetaIndex {
    static Meta knightMeta = new Meta("Knight", 75, 20, 20, 10);
    static Meta paladinMeta = new Meta("Paladin", 90, 20, 20, 10);
    static Meta rogueMeta = new Meta("Rogue", 50, 10, 10, 20);
    static Meta warriorMeta = new Meta("Warrior", 70, 30, 10, 10);
    static Meta wizardMeta = new Meta("Wizard", 50, 10, 10, 10);

    static Meta ogreMeta = new Meta("Ogre", 75, 20, 20, 5);
    static Meta skeletonMeta = new Meta("Skeleton", 50, 20, 20, 10);
    static Meta spiderMeta = new Meta("Spider", 30, 10, 10, 30);
    static Meta witchMeta = new Meta("Witch", 50, 15, 10, 10);
    static Meta zombieMeta = new Meta("Zombie", 60, 10, 10, 5);

    static Meta easyMonsterMeta = new Meta("Easy Monster", 30, 5, 5, 5);
    static Meta mediumMonsterMeta = new Meta("Medium Monster", 60, 10, 10, 10);
    static Meta hardMonsterMeta = new Meta("Hard Monster", 90, 25, 25, 20);

    static Meta smallMonsterMeta = new Meta("Small Monster", 10, 5, 5, 20);
    static Meta bigMonsterMeta = new Meta("Big Monster", 75, 20, 20, 5);

    public static Meta getKnightMeta() {
        return knightMeta;
    }

    public static Meta getPaladinMeta() {
        return paladinMeta;
    }

    public static Meta getRogueMeta() {
        return rogueMeta;
    }

    public static Meta getWarriorMeta() {
        return warriorMeta;
    }

    public static Meta getWizardMeta() {
        return wizardMeta;
    }

    public static Meta getOgreMeta() {
        return ogreMeta;
    }

    public static Meta getSkeletonMeta() {
        return skeletonMeta;
    }

    public static Meta getSpiderMeta() {
        return spiderMeta;
    }

    public static Meta getWitchMeta() {
        return witchMeta;
    }

    public static Meta getZombieMeta() {
        return zombieMeta;
    }

    public static Meta getEasyMonsterMeta() {
        return easyMonsterMeta;
    }

    public static Meta getMediumMonsterMeta() {
        return mediumMonsterMeta;
    }

    public static Meta getHardMonsterMeta() {
        return hardMonsterMeta;
    }

    public static Meta getSmallMonsterMeta() {
        return smallMonsterMeta;
    }

    public static Meta getBigMonsterMeta() {
        return bigMonsterMeta;
    }
}