package adventure.Item;

import adventure.Character.Character;

public class VisionPotion implements Item {
    private final int potency;

    public VisionPotion() {
        this.potency = (int) (Math.random() * 50);
    }

    public void use(Character character) {
        String message = String.format("Regained %d health!", this.potency);
        System.out.println(message);
    }
}
