package adventure.Action;

import adventure.Character.Character;

public abstract class Action {
    protected final String name;
    protected final String description;
    protected final int effect;

    protected Action(String name, String description, int damage) {
        this.name = "Strike";
        this.description = "A basic strike with a fist or weapon.";
        this.effect = 10;
    }

    public void printName() {
        System.out.println(this.name);
    }

    public void printDescription() {
        System.out.println(this.description);
    }

    public abstract void act(Character issuer, Character receiver);
}
