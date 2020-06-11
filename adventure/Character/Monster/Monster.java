package adventure.Character.Monster;

import adventure.Action.Action;
import adventure.Character.Character;
import adventure.Meta.Meta;

public abstract class Monster extends Character {

    protected Monster(Meta meta, Action mainAction, Action specialAction) {
        super(meta, mainAction, specialAction);
    }

    private static char getIcon(Monster m){
        return ( m.getCurrentHealth() > 0 ? 'X' : '~');
    }

    public String getName(){
        return this.meta.getType();
    }

    public char getIcon(){
        return getIcon(this);
    }
}
