package adventure.Action;

import static org.junit.jupiter.api.Assertions.*;

import adventure.Character.Hero.Hero;
import adventure.Character.Hero.HeroFactory;
import adventure.Character.Monster.Monster;
import adventure.Character.Monster.MonsterFactory;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class ChargeTest {

    @Test
    void act() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream originalOut = System.out;
        final Hero testAttacker = HeroFactory.makeWarrior("TestName");
        final Monster testOpponent = MonsterFactory.makeOgre();

        System.setOut(new PrintStream(outContent));
        ActionIndex.getChargeAction().act(testAttacker, testOpponent);
        assertEquals("Warrior charged Ogre for 40 damage!\n".trim(), outContent.toString().trim());
        System.setOut(originalOut);
    }

}
