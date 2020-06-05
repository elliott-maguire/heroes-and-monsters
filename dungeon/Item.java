package dungeon;

import java.io.Serializable;
import java.util.Random;

public abstract class Item implements Serializable {

    //sets max and min strength for all items
    //Made non static and non final so they may be over ridden in sub-classes
    protected int _MAX_STR_ = 15;
    protected int _MIN_STR_ = 5;

    private String name;
    private String effectPrint;
    private Character symbol;
    private boolean consumable;

    protected Item(String name, String effectPrint, Character symbol, boolean consume) {
        this.name = name;
        this.effectPrint = effectPrint;
        this.symbol = symbol;
        this.consumable = consume;
    }

    protected String getName(){
        return this.name;
    }

    protected String getEffect(){
        return this.effectPrint;
    }

    public Character getSymbol(){
        return this.symbol;
    }

    protected int getRandStrength(){
        Random rand = new Random();
        int str = _MAX_STR_ - rand.nextInt(_MAX_STR_-_MIN_STR_);
        return str;
    }

    public abstract boolean use(Hero h);

    public boolean isConsumable(){
        return this.consumable;
    }

}
