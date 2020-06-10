package adventure.Action;

import adventure.Character.Character;

public class Heal extends Action {
    public Heal() {
        super("Heal", "A healing spell.", 20);
    }

    /**
     * Executes a heal on a `Character` instance.
     *
     * Features a magic attack with a high base strength unreliant on any strength
     * or defense stats. Still speed based like other attacks.
     *
     * @param healer - A `Character` doing the healing.
     * @param target - A `Character` being healed.
     */
    public void act(Character healer, Character target) {
        int healEffect = (int) Math.random() * (this.effect + healer.meta.getStrength());

        target.heal(healEffect);

        String message = String.format("%s healed for %d points!", target.meta.getType(), healEffect);
        System.out.println(message);
    }
}
