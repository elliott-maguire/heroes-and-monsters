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

    public Item getItem(){
        return this.item;
    }
    public Item takeItem(){
        Item temp = this.item;
        this.item = null;
        return temp;
    }
    public Monster getMonster(){
        return this.monster;
    }


    public void setItem(Item i){
        this.item = i;
    }
    public void setHero(Hero h){
        this.hero = h;
    }
    public void setMonster(Monster m){
        this.monster = m;
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

    public Wall getUp(){
        return this.up;
    }
    public Wall getDown(){
        return this.down;
    }
    public Wall getLeft(){
        return this.left;
    }
    public Wall getRight(){
        return this.right;
    }

    private static String makeRowString(int x, Room room){
        String row = "ERROR";

        switch(x){
            case 0:
                row = room.getUp().toString();
                break;
            case 1:
                String m = (room.hasMonster() ? room.getMonster().getIcon()+"" : " ");
                String h = (room.hasHero()? "&" : " ");
                String i = (room.hasItem()? room.getItem().getIcon()+"" : " ");
                row = room.getLeft().toString() + " " + m + " " + h + " " + i + " " + room.getRight().toString();
                break;
            case 2:
                row = room.getDown().toString();

        }

        return row;
    }
    public String getRow(int x){
        return makeRowString(x, this);
    }

}
