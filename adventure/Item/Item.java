package adventure.Item;

import adventure.Character.Character;

public interface Item {
    void use(Character character);
    char getIcon();
}