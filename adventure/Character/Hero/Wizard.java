package adventure.Character.Hero;

import adventure.Action.Action;
import adventure.Meta.Meta;

public class Wizard extends Hero {
    protected Wizard(String name, Meta meta, Action mainAction, Action specialAction) {
        super(name, meta, mainAction, specialAction);
    }
}
