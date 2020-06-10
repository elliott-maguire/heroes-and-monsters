package adventure.Action;

import adventure.Character.Character;

public class Fireball extends Action {
    public Fireball() {
        super("Fireball", "A powerful magic attack.", 20);
    }

    /**
     * Executes an attack on a `Character` opponent.
     *
     * Features a magic attack with a high base strength unreliant on any strength
     * or defense stats. Still speed based like other attacks.
     *
     * @param attacker - A `Character` doing the attack.
     * @param opponent - A `Character` getting attacked.
     */
    public void act(Character attacker, Character opponent) {
        int attackDamage = this.effect;

        if (attacker.meta.getSpeed() > opponent.meta.getSpeed()) {
            opponent.hurt(attackDamage);

            String message = String.format("%s fried %s for %d damage!", attacker.meta.getType(),
                    opponent.meta.getType(), attackDamage);
            System.out.println(message);
        } else {
            String message = String.format("%s missed!", attacker.meta.getType());
            System.out.println(message);
        }
    }
}
