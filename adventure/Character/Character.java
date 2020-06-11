package adventure.Character;

import adventure.Action.Action;
import adventure.Meta.Meta;


public abstract class Character {
    public final Meta meta;
    private int currentHealth;
    protected final Action mainAction;
    protected final Action specialAction;

    protected Character(Meta meta, Action mainAction, Action specialAction) {
        this.meta = meta;
        this.currentHealth = meta.getMaxHealth();
        this.mainAction = mainAction;
        this.specialAction = specialAction;
    }

    public boolean isAlive(){
        return (this.getCurrentHealth() > 0);
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    /**
     * Hurt (subtract health from) the `Character` with a given damage amount
     * (`delta`). This is a convenience method.
     *
     * @param delta - The `int` damage to modify `currentHealth` with.
     */
    public void hurt(int delta) {
        this.setCurrentHealth(this.getCurrentHealth() - delta);
    }

    /**
     * Heal (add health to) the `Character` with a given healing amount (`delta`).
     * This is a convenience method.
     *
     * @param delta - The `int` healing value to modify `currentHealth` with.
     */
    public void heal(int delta) {
        this.setCurrentHealth(this.getCurrentHealth() + delta);
    }

    /**
     * Carries out the main attack on an opponent.
     *
     * @param opponent - A `Character` representing an opponent.
     */
    public void doMainAttack(Character opponent) {
        this.mainAction.act(this, opponent);
    }

    /**
     * Carries out the special attack on an opponent.
     *
     * @param opponent - A `Character` representing an opponent.
     */
    public void doSpecialAttack(Character opponent) {
        this.specialAction.act(this, opponent);
    }

    public Action getSpecialAction() {
        return specialAction;
    }
}
