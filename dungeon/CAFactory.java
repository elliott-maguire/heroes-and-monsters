package dungeon;

import java.util.HashMap;

public class CAFactory {

    private static HashMap<String, CharacterAttribsConcrete> map = new HashMap<String, CharacterAttribsConcrete>();

    public static CharacterAttribsConcrete getAttack(String n, String atkType, double chance, int atkSpeed, int dmgMin, int dmgMax, Character symbol){

        String key = ( n + atkType + (chance) + (atkSpeed) + (dmgMin) + (dmgMax) + symbol);
        CharacterAttribsConcrete atk = map.get(key);

        if(atk == null){
            atk = new CharacterAttribsConcrete( n, atkType, chance, atkSpeed, dmgMin, dmgMax, symbol);
            map.put(key, atk);
        }


        return atk;

    }


}
