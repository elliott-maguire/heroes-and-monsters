package adventure.Character.Hero;

import java.util.ArrayList;

import adventure.Action.Action;
import adventure.Character.Character;
import adventure.Item.HealthPotion;
import adventure.Item.Item;
import adventure.Item.PillarOfOO;
import adventure.Item.VisionPotion;
import adventure.Meta.Meta;

public abstract class Hero extends Character {
    private final String name;
    private int visionLevel;
    private ArrayList<HealthPotion> healthPotions;
    private ArrayList<VisionPotion> visionPotions;
    private ArrayList<PillarOfOO> pillarOfOOs;

    protected Hero(String name, Meta meta, Action mainAction, Action specialAction) {
        super(meta, mainAction, specialAction);

        this.name = name;

        this.healthPotions = new ArrayList<>();
        this.visionPotions = new ArrayList<>();
        this.pillarOfOOs = new ArrayList<>();

        this.visionLevel = 0;
    }

    public void getItem(Item i){
        String found = "You found a ";
        switch(i.getIcon()){
            case 'H':
                found += "Health Potion!";
                this.healthPotions.add((HealthPotion) i);
                break;

            case 'V':
                found += "Vision Potion!";
                this.visionPotions.add((VisionPotion) i);
                break;

            case 'P':
                found += "Pillar of OO!";
                this.pillarOfOOs.add((PillarOfOO) i);
                break;
        }

        System.out.println(found);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String meta = String.format("%s\n%s\nCurrent Health: %s\n\n", this.getName(), this.meta.getType(),
                this.getCurrentHealth());
        String inventory = String.format(
                "INVENTORY\n=========\n\nHealth Potions: %d\nVision Potions: %d\nPillars of OO: %d",
                this.healthPotions.toArray().length, this.visionPotions.toArray().length,
                this.pillarOfOOs.toArray().length);

        return meta + inventory;
    }

    public void useHealthPotion() {
        if (this.healthPotions.toArray().length > 0) {
            HealthPotion potion = this.healthPotions.remove(0);
            potion.use(this);
        } else {
            System.out.println("You don't have any health potions left!");
        }
    }

    public void useVisionPotion() {
        if (this.visionPotions.toArray().length > 0) {
            VisionPotion potion = this.visionPotions.remove(0);
            potion.use(this);
            visionLevel = 1;
        } else {
            System.out.println("You don't have any vision potions left!");
        }
    }

    public void readPillars(){
        int s = this.pillarOfOOs.size();

        System.out.println("You have " + s + " pillar" +(s>1?"s" :"" ) +" of OO.");

        if(s > 0) {
            System.out.print("The pillar" + (s > 1 ? "s are" : " is") + " engraved in a foreign script: ");

            for(PillarOfOO p: this.pillarOfOOs){
                System.out.print("<" + p.getName()+ ">  ");
            }

            System.out.println("What could this mean?");
        }




    }

    public void setVisionLevel(int v){
        this.visionLevel = v;
    }

    public int getVisionLevel(){
        return this.visionLevel;
    }

}
