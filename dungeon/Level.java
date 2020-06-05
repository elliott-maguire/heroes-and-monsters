package dungeon;

import javafx.geometry.Point2D;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

public class Level implements Serializable {

    public static final int _ROWS = 5;
    public static final int _COL = 5;

    private static final int _PBLTY = 10;

    private static HashMap<Integer, Room> map;

    public static void init(){
        map = BuildRxC(_ROWS, _COL);
        populateLevel();
    }

    public static void FORCE_Populate(){
        populateLevel();
    }

    private static void populateLevel(){
        Random chance = new Random();

        for(int i = 0; i < _ROWS; i++){
            for(int j = 0; j < _COL; j++) {

                if (chance.nextInt(100) < _PBLTY) {
                    get(i,j).setMonster( MFactory.rand() );
                }

                if( chance.nextInt(100) < _PBLTY ){
                    get(i,j).setItem( IFactory.rand() );
                }

            }

        }

        Iterator<PillarOfOO> pList = PillarOfOO.createPillars();

        for(int i = 0; i < 4; i++){
            int x = chance.nextInt(_ROWS);
            int y = chance.nextInt(_COL );

            if( get(x,y).noItem() ){
                get(x,y).setItem( pList.next() );
            }
            else{
                i--;
            }

        }

    }

    private static Integer key(int x, int y){
        return (x*31 + y);
    }

    private static HashMap<Integer, Room> BuildRxC(int rows, int col){

        HashMap<Integer, Room> map = new  HashMap<Integer, Room>();
        int amt = rows * col;

        for(int i = 0; i < rows; i++){

            for(int j = 0; j < col; j++){

                Integer crd = key(i,j);
                Room temp = new Room();

                if(i == 0){
                    temp.setWall(0, WALL.WALLH);
                }

                if(i == _ROWS-1){
                    temp.setWall(2, WALL.WALLH);
                }

                if(j == 0){
                    temp.setWall(3, WALL.WALLV);
                }

                if(j == _COL-1){
                    temp.setWall(1, WALL.WALLV);
                }

                map.put(key(i,j), temp);

            }

        }
        return map;
    }

    private static Room get(int x, int y){

        return map.get( key(x,y) );
    }

    public static void enterRoom(int x, int y){
        get(x,y).enterRoom();
    }

    public static void leaveRoom(int x, int y){
        get(x,y).leaveRoom();
    }

    public static void drawView(){
        //prints rows

        Point2D crd = new Point2D(0,0);
        int x = 0;
        int y = 0;
        int existCheck = 0;
        ArrayList<Room> roomList = new ArrayList<Room>();

        do{
            y = 0;
            roomList = new ArrayList<Room>();

            if( get(x,y) != null ){

                while( get(x,y) != null ){

                    roomList.add( get(x,y) );
                    y++;

                }


                for(int i = 0; i < 6; i++){
                    String temp = "";
                    for(Room rm: roomList){

                        temp += rm.getRow(i) ;

                    }

                    System.out.println(temp);

                }

            }
            else
                existCheck++;

            x++;
        }while(existCheck < 2);

    }

    public static void drawRoom(int x, int y){
        get(x,y).draw();
    }

    public static boolean isVacant(int x, int y){
        return get(x,y).isVacant();
    }

    public static boolean itemInRoom(int x, int y){
        return ! get(x,y).noItem();
    }

    public static Item takeItem(int x, int y){
        return get(x,y).takeItem();
    }

    public static Monster getMonster(int x, int y){
        return get(x,y).takeMonster();
    }

    public static HashMap<Integer, Room> getMap(){
        return map;
    }

    public static void setMap(HashMap<Integer, Room> load){
        map = load;
    }
}
