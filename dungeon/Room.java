package dungeon;

import java.io.Serializable;

public class Room implements Serializable {


    //the printerInfo array represents each room, each index position is as follows:
    //
    //		   up
    //		|--0--|
    // left 3     1  right
    //		|--2--|
    //		  down
    //


    private Item obj;
    private Monster tenant;
    private boolean noItem = true;
    private boolean vacant = true;
    private WALL[] printerInfo;
    private boolean hero = false;

    public Room(Item thing){
        this.setItem(thing);
        this.vacant = true;
        this.printerInit();
    }

    public Room(Monster enemy){
        this.setMonster(enemy);
        this.noItem = true;
        this.printerInit();
    }

    public Room(){
        this.noItem = true;
        this.vacant = true;
        this.printerInit();
    }

    public void setMonster(Monster enemy){
        this.vacant = false;
        this.tenant = enemy;
    }


    public void setItem(Item thing){
        this.noItem = false;
        this.obj = thing;
    }

    public boolean noItem(){
        return this.noItem;
    }

    public boolean isVacant(){
        return this.vacant;
    }

    public Item takeItem(){
        this.noItem = true;
        Item i = this.obj;
        this.obj = null;
        return i;
    }

    private void printerInit(){
        //		   up
        //		|--0--|
        // left 3     1  right
        //		|--2--|
        //		  down
        this.printerInfo = new WALL[4];

        this.printerInfo[0] = WALL.DOORH;
        this.printerInfo[1] = WALL.DOORV;
        this.printerInfo[2] = WALL.DOORH;
        this.printerInfo[3] = WALL.DOORV;

    }

    public void setWall(int x, WALL wall){
        if(x < 4 && x >= 0)
            this.printerInfo[x] = wall;
    }

    public String getRow(int x){

        String temp = "";

        switch (x){
            case 0:
                return ("*" + this.printerInfo[0].print() + "*");

            case 1:
                temp += this.printerInfo[3].print().charAt(0);
                temp += "    "+ ( this.hero ? "&": " ") +"   ";
                temp += this.printerInfo[1].print().charAt(0);
                break;

            case 2:
                temp += this.printerInfo[3].print().charAt(1);
                temp += "  " + ( this.noItem ? " " : this.obj.getSymbol() ) + "     " ;
                temp += this.printerInfo[1].print().charAt(1);
                break;

            case 3:
                temp += this.printerInfo[3].print().charAt(2);
                temp += "     " + ( this.vacant ? " " : "X" ) + "  " ;
                temp += this.printerInfo[1].print().charAt(2);
                break;

            case 4:
                temp += this.printerInfo[3].print().charAt(3);
                temp += "        ";
                temp += this.printerInfo[1].print().charAt(3);
                break;

            case 5:
                return ("*" + this.printerInfo[2].print() + "*");

        }

        return temp;

    }

    public void enterRoom(){
        this.hero = true;
    }

    public void leaveRoom(){
        this.hero = false;
    }

    public String[] toStringArr(){

        String[] temp = new String[6];

        for(int i = 0; i < temp.length; i++){
            temp[i] = getRow(i);
        }

        return temp;
    }

    public void draw(){

        String[] temp = this.toStringArr();

        for(String s: temp){
            System.out.println(s);
        }

    }

    public Monster takeMonster(){
        this.vacant = true;
        Monster m = this.tenant;
        this.tenant = null;
        return m;
    }

}
