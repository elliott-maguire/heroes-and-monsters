package adventure.Character.Hero;

import adventure.Action.ActionIndex;
import adventure.Meta.MetaIndex;

public class HeroFactory {
    public static Hero makeKnight(String name) {
        return new Knight(name, MetaIndex.getKnightMeta(), ActionIndex.getStrikeAction(), ActionIndex.getChargeAction());
    }

    public static Hero makePaladin(String name) {
        return new Paladin(name, MetaIndex.getPaladinMeta(), ActionIndex.getCrushAction(), ActionIndex.getHealAction());
    }

    public static Hero makeRogue(String name) {
        return new Rogue(name, MetaIndex.getRogueMeta(), ActionIndex.getStrikeAction(), ActionIndex.getQuickStrikeAction());
    }

    public static Hero makeWarrior(String name) {
        return new Warrior(name, MetaIndex.getWarriorMeta(), ActionIndex.getStrikeAction(), ActionIndex.getCrushAction());
    }

    public static Hero makeWizard(String name) {
        return new Wizard(name, MetaIndex.getWizardMeta(), ActionIndex.getFireballAction(), ActionIndex.getHealAction());
    }
}
