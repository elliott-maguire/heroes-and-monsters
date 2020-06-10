package adventure.Dungeon;

import adventure.Character.Hero.Hero;
import adventure.Character.Monster.Monster;
import adventure.Item.Item;

import java.util.ArrayList;

public class Room {
    private ArrayList<String> grid;
    private int x, y;
    private Wall up, down, left, right;

    private Monster monster;
    private Hero hero;
    private Item item;

    Room(Hero h, Monster m, Item i){
        this.hero = h;
        this.monster = m;
        this.item = i;
    }

    public Boolean hasMonster(){
        return !(this.monster == null);
    }

    public Boolean hasHero(){
        return !(this.hero == null);
    }

    public Boolean hasItem(){
        return !(this.item == null);
    }

    public Item takeItem(){
        Item temp = this.item;
        this.item = null;
        return temp;
    }

    public void setUpperWall(Wall w){
        this.up = w;
    }

    public void setLowerWall(Wall w){
        this.down = w;
    }

    public void setLeftWall(Wall w){
        this.left = w;
    }

    public void setRightWall(Wall w){
        this.right = w;
    }


    //non functional
    /*
    public Wall

    private static String getRowString(int x, Room room){
        String row = "ERROR";

        switch(x){
            case 0:
                row = u.toString();
                break;
            case 1:
                //row = "" + l.toString()
                break;
            case 2:
                row = d.toString();

        }



        return row;
    }


    public String getRow(int x){
        return getRowString(x, this.up, this.down, this.left, this.right);
    }
*/

}
