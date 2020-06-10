package adventure.Action;

public class ActionIndex {
    static Action chargeAction = new Charge();
    static Action crushAction = new Crush();
    static Action fireballAction = new Fireball();
    static Action healAction = new Heal();
    static Action quickStrikeAction = new QuickStrike();
    static Action strikeAction = new Strike();

    public static Action getChargeAction() {
        return chargeAction;
    }

    public static Action getCrushAction() {
        return crushAction;
    }

    public static Action getFireballAction() {
        return fireballAction;
    }

    public static Action getHealAction() {
        return healAction;
    }

    public static Action getQuickStrikeAction() {
        return quickStrikeAction;
    }

    public static Action getStrikeAction() {
        return strikeAction;
    }
}