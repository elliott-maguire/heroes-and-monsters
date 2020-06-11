package adventure.Character.Hero;

import static org.junit.jupiter.api.Assertions.*;

import adventure.Item.HealthPotion;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class HeroTest {

    @Test
    void toStringTest() {
        Hero testHero = HeroFactory.makeWarrior("TestHero");

        assertEquals("TestHero\nWarrior\nCurrent Health: 70\n\nINVENTORY\n=========\n\nHealth Potions: 0\nVision Potions: 0\nPillars of OO: 0", testHero.toString());
    }


}
