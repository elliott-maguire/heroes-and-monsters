package adventure.Character.Hero;

import adventure.Action.Action;
import adventure.Meta.Meta;

public class Rogue extends Hero {
    protected Rogue(String name, Meta meta, Action mainAction, Action specialAction) {
        super(name, meta, mainAction, specialAction);
    }
}
