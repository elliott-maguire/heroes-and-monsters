package adventure.Item;

import adventure.Character.Character;

public class PillarOfOO implements Item {
    public static final char icon = 'P';


    @Override
    public void use(Character character) {

    }

    @Override
    public char getIcon() {
        return icon;
    }
}