package adventure.Action;

import adventure.Character.Character;

public abstract class Action {
    protected final String name;
    protected final String description;
    protected final int effect;

    protected Action(String name, String description, int damage) {
        this.name = name;
        this.description = description;
        this.effect = damage;
    }

    public void printName() {
        System.out.println(this.name);
    }

    public void printDescription() {
        System.out.println(this.description);
    }

    public abstract void act(Character issuer, Character receiver);
}
