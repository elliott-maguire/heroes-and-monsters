package adventure.Action;

import adventure.Character.Character;

public class QuickStrike extends Action {
    public QuickStrike() {
        super("Quick Strike", "A fast and light attack that always hits first.", 5);
    }

    /**
     * Executes an attack on a `Character` opponent.
     *
     * Features a fast and light attack with a strength modifier of the difference
     * between attacker strength and opponent defense. It is unaffected by speed and
     * will always hit.
     *
     * @param attacker - A `Character` doing the attack.
     * @param opponent - A `Character` getting attacked.
     */
    public void act(Character attacker, Character opponent) {
        int attackDamage = this.effect;

        int modifier = attacker.meta.getStrength() - opponent.meta.getDefense();
        attackDamage += modifier;

        opponent.hurt(attackDamage);

        String message = String.format("%s quickly struck %s for %d damage!", attacker.meta.getType(),
                opponent.meta.getType(), attackDamage);
        System.out.println(message);
    }
}
