package adventure.Item;

import static org.junit.jupiter.api.Assertions.*;

import adventure.Character.Hero.Hero;
import adventure.Character.Hero.HeroFactory;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class HealthPotionTest {

    @Test
    void use() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        final PrintStream originalOut = System.out;
        HealthPotion testPotion = new HealthPotion();
        Hero testHero = HeroFactory.makeWarrior("TestHero");
        System.setOut(new PrintStream(outContent));

        testPotion.use(testHero);
        assertEquals(String.format("Regained %d health!\n", testPotion.getPotency()).trim(), outContent.toString().trim());
        System.setOut(originalOut);
    }
}
