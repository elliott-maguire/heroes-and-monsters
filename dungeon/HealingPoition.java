package dungeon;

public class HealingPoition extends Item{
    private static final int _MAX = 15;
    private static final int _MIN = 5;

    protected HealingPoition() {
        super("Health Potion", "drinks potion and heals themself", 'H', true);
    }

    @Override
    public boolean use(Hero h) {
        int str = this.getRandStrength();

        h.setHP( h.getHP() + str );

        System.out.println(h.getName() + " drinks the potion, raising their HP by " + str);

        return this.isConsumable();
    }
}
