package adventure.Action;

import static org.junit.jupiter.api.Assertions.*;

import adventure.Character.Hero.*;
import adventure.Character.Monster.*;
import adventure.Character.Character;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class QuickStrikeTest {

    @Test
    void act() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream originalOut = System.out;
        final Hero testAttacker = HeroFactory.makeWarrior("TestName");
        final Monster testOpponent = MonsterFactory.makeOgre();

        System.setOut(new PrintStream(outContent));
        ActionIndex.getQuickStrikeAction().act(testAttacker, testOpponent);
        assertEquals("Warrior quickly struck Ogre for 15 damage!\n".trim(), outContent.toString().trim());
        System.setOut(originalOut);
    }

}
