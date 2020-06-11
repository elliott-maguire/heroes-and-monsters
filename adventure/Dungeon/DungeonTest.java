package adventure.Dungeon;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class DungeonTest {

    public static Dungeon d;

    @BeforeAll
    static void init(){
        d = new Dungeon();
        d.populateBoard();
    }

    /**
     ** Layout of 5x5 board in Room ArrayList
     ** room index=0,1,2...etc
     **
     **   X:  0  1  2  3  4
     **     ------------------
     ** Y:0 | 0  1  2  3  4  |
     **   1 | 5  6  7  8  9  |
     **   2 | 10 11 12 13 14 |
     **   3 | 15 16 17 18 19 |
     **   4 | 20 21 22 23 24 |
     **     ------------------
     **
     **/

    @Test
    void boardIndex(){
        int i = Dungeon.boardIndex(1, 3);
        assertEquals(16, i);
        i = Dungeon.boardIndex(0, 0);
        assertEquals(0, i);
        i = Dungeon.boardIndex(4, 4);
        assertEquals(24, i);
    }

    @Test
    void dungeonPrinter(){
        d.drawBoard();
    }


    @Test
    void drawRoom(){
        d.drawRoom(4,4);
        d.drawRoom(3,2);
        d.drawRoom(1,2);

    }



}