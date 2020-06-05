package dungeon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class PillarOfOO extends Item{

    private static Iterator<String> pillars;

    public static Iterator<PillarOfOO> createPillars(){

        ArrayList<String> pRead = new ArrayList<String>();

        pRead.add("Abstraction");
        pRead.add("Encapsulation");
        pRead.add("Inheritance");
        pRead.add("Polymorphism");

        Collections.shuffle(pRead);

        String effect = "A pillar of OO. The glowing inscription reads: '";
        Character symbol = 'P';

        ArrayList<PillarOfOO> pList = new ArrayList<PillarOfOO>();

        for(String s: pRead){
            pList.add( new PillarOfOO(s, effect, symbol) );
        }

        return pList.iterator();
    }

    protected PillarOfOO(String name, String effectPrint, Character symbol) {
        super(name, effectPrint, symbol, false);
    }

    @Override
    public boolean use(Hero h) {
        System.out.println(this.getEffect() + this.getName().toUpperCase() + "'. What could this mean?");
        return this.isConsumable();
    }

}
