package adventure.Action;

import adventure.Character.Character;

public class Strike extends Action {
    public Strike() {
        super("Strike", "A basic strike with a fist or weapon.", 10);
    }

    /**
     * Executes an attack on a `Character` opponent.
     *
     * Features a medium attack with a strength modifier based on the difference
     * between the attacker's strength and opponent's defense.
     *
     * @param attacker - A `Character` doing the attack.
     * @param opponent - A `Character` getting attacked.
     */
    public void act(Character attacker, Character opponent) {
        int attackDamage = this.effect;

        int modifier = attacker.meta.getStrength() - opponent.meta.getDefense();
        attackDamage += modifier;

        if (attacker.meta.getSpeed() > opponent.meta.getSpeed()) {
            opponent.hurt(attackDamage);

            String message = String.format("%s struck %s for %d damage!", attacker.meta.getType(),
                    opponent.meta.getType(), attackDamage);
            System.out.println(message);
        } else {
            String message = String.format("%s missed!", attacker.meta.getType());
            System.out.println(message);
        }
    }
}
