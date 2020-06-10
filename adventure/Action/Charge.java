package adventure.Action;

import adventure.Character.Character;

public class Charge extends Action {
    public Charge() {
        super("Charge", "A heavy, unstoppable attack with a run-up.", 10);
    }

    /**
     * Executes an attack on a `Character` opponent.
     *
     * Features a heavy attack with a base strength modifier of the attacker and is
     * unaffected by the opponent's defense stat.
     *
     * @param attacker - A `Character` doing the attack.
     * @param opponent - A `Character` getting attacked.
     */
    public void act(Character attacker, Character opponent) {
        int attackDamage = this.effect + attacker.meta.getStrength();

        if (attacker.meta.getSpeed() > opponent.meta.getSpeed()) {
            opponent.hurt(attackDamage);

            String message = String.format("%s charged %s for %d damage!", attacker.meta.getType(),
                    opponent.meta.getType(), attackDamage);
            System.out.println(message);
        } else {
            String message = String.format("%s missed!", attacker.meta.getType());
            System.out.println(message);
        }
    }
}
