package adventure.Item;

import java.util.Random;

public class ItemFactory {
    public static Item makeHealthPotion(){
        return new HealthPotion();
    }
    public static Item makeVisionPotion(){
        return new VisionPotion();
    }
    public static Item[] makeAllPillars(){
        return new PillarOfOO[]{new PillarOfOO("Encapsulation"), new PillarOfOO("Abstraction"), new PillarOfOO("Inheritance"), new PillarOfOO("Polymorphism")};
    }

    public static Item makeRandom(){
        int i = new Random().nextInt() % 2;

        if(i == 0)
            return makeHealthPotion();

        return makeVisionPotion();
    }

}
