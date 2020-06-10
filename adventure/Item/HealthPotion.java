package adventure.Item;

import adventure.Character.Character;

public class HealthPotion implements Item {
    private static final char icon = 'H';

    private final int potency;

    public HealthPotion() {
        this.potency = (int) (Math.random() * 50);
    }

    public void use(Character character) {
        character.heal(this.potency);

        String message = String.format("Regained %d health!", this.potency);
        System.out.println(message);
    }

    @Override
    public char getIcon() {
        return icon;
    }
}
