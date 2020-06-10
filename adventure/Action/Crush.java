package adventure.Action;

import adventure.Character.Character;

public class Crush extends Action {
    public Crush() {
        super("Crush", "A heavy blow that breaks through opponents' defense.", 15);
    }

    /**
     * Executes an attack on a `Character` opponent.
     *
     * Features a heavy attack with a base strength modifier that is hindered by a
     * -5 speed modifier that, if lower than the opponent's base speed, will miss.
     *
     * @param attacker - A `Character` doing the attack.
     * @param opponent - A `Character` getting attacked.
     */
    public void act(Character attacker, Character opponent) {
        int attackDamage = this.effect + attacker.meta.getStrength();

        if (attacker.meta.getSpeed() - 5 > opponent.meta.getSpeed()) {
            opponent.hurt(attackDamage);

            String message = String.format("%s crushed %s for %d damage!", attacker.meta.getType(),
                    opponent.meta.getType(), attackDamage);
            System.out.println(message);
        } else {
            String message = String.format("%s missed!", attacker.meta.getType());
            System.out.println(message);
        }
    }
}
