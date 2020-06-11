package adventure.Item;

import adventure.Character.Character;

public class PillarOfOO implements Item {
    public static final char icon = 'P';
    private static String name;

    PillarOfOO(String principal){
        this.name = principal;
    }


    @Override
    public void use(Character character) {

    }

    public String getName(){
        return this.name;
    }

    @Override
    public char getIcon() {
        return icon;
    }
}