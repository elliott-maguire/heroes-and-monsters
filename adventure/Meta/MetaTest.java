package adventure.Meta;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MetaTest {
    @Test
    void getType() {
        Meta m = new Meta("Animal", 22, 33, 44, 55);
        assertEquals("Animal",m.getType());
    }


    @Test
    void getMaxHealth() {
        Meta m = new Meta("Animal", 22, 33, 44, 55);
        assertEquals(22,m.getMaxHealth());
    }

    @Test
    void getStrength() {
        Meta m = new Meta("Animal", 22, 33, 44, 55);
        assertEquals(33,m.getStrength());
    }

    @Test
    void getDefense() {
        Meta m = new Meta("Animal", 22, 33, 44, 55);
        assertEquals(44,m.getDefense());
    }

    @Test
    void getSpeed() {
        Meta m = new Meta("Animal", 22, 33, 44, 55);
        assertEquals(55,m.getSpeed());
    }



}