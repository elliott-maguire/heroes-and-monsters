package adventure.Action;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ActionTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final Action testAction = new Charge();


    @Test
    void printName() {
        System.setOut(new PrintStream(outContent));
        testAction.printName();
        assertEquals("Charge\n".trim(), outContent.toString().trim());
        System.setOut(originalOut);
    }

    @Test
    void printDescription() {
        System.setOut(new PrintStream(outContent));
        testAction.printDescription();
        assertEquals("A heavy, unstoppable attack with a run-up.\n".trim(), outContent.toString().trim());
        System.setOut(originalOut);
    }

}
