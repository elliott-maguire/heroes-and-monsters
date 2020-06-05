package dungeon;

import java.util.Random;

public enum IFactory {
    HP,
    VP;

    private static Random random = new Random();

    public Item make(){

        switch(this){
            case HP:
                return new HealingPoition();
            case VP:
                return new VisionPotion();
        }

        return rand();
    }

    public static Item rand(){
        IFactory[] items = IFactory.values();
        return items[ random.nextInt( items.length ) ].make();
    }

}
