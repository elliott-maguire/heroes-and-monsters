package dungeon;

import java.io.Serializable;

public interface CharacterAttribs extends Serializable {

    public String  getName();
    public String getAttackType();
    public double getChanceToHit();
    public int getAttackSpeed();
    public int getDamageMin();
    public int getDamageMax();
    public Character getSymbol();

}
