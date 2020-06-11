package adventure.Dungeon;

import adventure.Character.Monster.Monster;
import adventure.Character.Monster.MonsterFactory;
import adventure.Item.Item;
import adventure.Item.ItemFactory;

import java.util.ArrayList;
import java.util.Random;

public class Dungeon {
    private static final int _ROW = 5;
    private static final int _COL = 5;
    private static final int _ITEM_POSIBILITY = 15;
    private static final int _MONSTER_POSSIBILITY = 20;
    private static final int _DRAW_DIST = 3;
    private ArrayList<Room> board;


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

    public static int boardIndex(int x, int y){
        return (x % _ROW) + (y * _COL);
    }


    /**
     * Build new list of Rooms for board
     */
    private static void BuildBoard(ArrayList<Room> board){
        board = new ArrayList<Room>();
        Random rand = new Random();

        for(int i = 0; i < _COL; i++){
            for(int j = 0; j < _ROW; j++){
                Monster m = MonsterFactory.makeRandom();
                Item item = null;

                if(rand.nextInt(101) <  _ITEM_POSIBILITY)
                    item = ItemFactory.makeRandom();

                Room room = new Room(null, m, item);

                //wall assignment
                room.setLeftWall( ( i == 0 ? Wall.WALL_INNER_VERTICAL : Wall.DOOR_VERTICAL) );
                room.setUpperWall( ( j == 0 ? Wall.WALL_INNER_HORIZONTAL : Wall.DOOR_HORIZONTAL) );
                room.setRightWall( (i == _COL-1 ? Wall.WALL_INNER_VERTICAL : Wall.DOOR_VERTICAL) );
                room.setLowerWall( (j == _ROW-1 ? Wall.WALL_INNER_HORIZONTAL : Wall.DOOR_HORIZONTAL) );

                board.add(room);
            }
        }

    }


    /**
     * Iterate through each `Room` and call their own `populate` methods.
     */
    public void populateBoard() {
        //BuildBoard(this.board);
        board = new ArrayList<Room>();
        Random rand = new Random();

        for(int i = 0; i < _ROW; i++){
            for(int j = 0; j < _COL; j++){
                Monster m = null;
                Item item = null;

                if(rand.nextInt(101) <  _MONSTER_POSSIBILITY)
                    m = MonsterFactory.makeRandom();

                if(rand.nextInt(101) <  _ITEM_POSIBILITY)
                    item = ItemFactory.makeRandom();

                Room room = new Room(null, m, item);

                //wall assignment
                room.setLeftWall( ( j == 0 ? Wall.WALL_OUTER_VERTICAL : Wall.DOOR_VERTICAL) );
                room.setUpperWall( ( i == 0 ? Wall.WALL_OUTER_HORIZONTAL : Wall.DOOR_HORIZONTAL) );
                room.setRightWall( (j == _COL-1 ? Wall.WALL_OUTER_VERTICAL : Wall.DOOR_VERTICAL) );
                room.setLowerWall( (i == _ROW-1 ? Wall.WALL_OUTER_HORIZONTAL : Wall.DOOR_HORIZONTAL) );

                board.add(room);
            }
        }
    }

    /**
     * Iterate through all `Room`s and call their own `drawGrid` methods, then
     * concatenate and print them.
     */
    public void drawBoard() {

        String fill = "";
        for (int fil = 0; fil < _COL; fil++) {
            fill += Wall.FILLER;
        }
        fill += "\n";

        for(int i = 0; i < _ROW; i++){
            String print = "";

            for(int j = 0; j < _DRAW_DIST; j++){
                if(j==1)
                    print += fill;

                for(int k = 0; k < _COL; k++){
                    print += this.board.get( boardIndex(k, i) ).getRow(j);

                }
                print+="\n";

                if(j==1)
                    print += fill;
            }

            System.out.print(print);
        }

    }

    public void drawRoom(int x, int y){
        int index = boardIndex(x,y);
        String print = "";

        print += this.board.get(index).getRow(0);
        print += "\n";
        print += Wall.FILLER;
        print += "\n";
        print += this.board.get(index).getRow(1);
        print += "\n";
        print += Wall.FILLER;
        print += "\n";
        print += this.board.get(index).getRow(2);

        System.out.println(print);

    }
}
