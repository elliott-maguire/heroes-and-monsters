package dungeon;

public class VisionPotion extends Item{


    protected VisionPotion() {
        super("Vision Potion", " drinks vision potion. ", 'V', true);
    }

    @Override
    public boolean use(Hero h) {
        int str = this.getRandStrength();
        h.setVision(str);

        System.out.println(h.getName() + this.getEffect() + h.getName() + " becomes shocked to find they can now see 360 degrees in all directions.");

        return this.isConsumable();
    }
}
