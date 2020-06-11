package adventure.Dungeon;

import adventure.Character.Hero.Hero;
import adventure.Character.Hero.HeroFactory;
import adventure.Character.Monster.Monster;
import adventure.Item.Item;

import java.util.Scanner;

public class DungeonAdventure {

    private static Scanner kb;
    private static Hero hero;
    private static Dungeon level1;
    private static int x, y;

    private static void initializeFields(){
        kb = new Scanner(System.in);
        heroPicker();
        level1 = new Dungeon();
        level1.populateBoard();
        x = 0;
        y = 0;

    }

    private static void heroPicker(){
        int choice;
        String name = "";
        System.out.println("Enter name:");
        name = kb.nextLine();

        do {
        System.out.println("Choose a hero:\n" +
                "1. Warrior\n" +
                "2. Rogue\n" +
                "3. Knight\n" +
                "4. Thief\n" +
                "5. Thief\n" +;


            choice = kb.nextInt();

            switch (choice) {
                case 1:
                    hero = HeroFactory.makeWarrior(name);

                case 2:
                    hero = HeroFactory.makeRogue(name);

                case 3:
                    hero = HeroFactory.makeKnight(name);

                case 4:
                    hero = HeroFactory.makePaladin(name);

                case 5:
                    hero = HeroFactory.makeWizard(name);

                default:
                    System.out.println("INVALID INPUT: PRESS ENTER TO CONTINUE");
                    kb.next();

            }//end switch

        }while(hero != null);
    }

    private static boolean thereIsItem(){
        return level1.itemInRoom( x, y );
    }

    public static void gameLoop(){



        do{
            initializeFields();

            do {
                draw();
            }while(playerChoice());

        }while(playAgain());

    }
    private static void pause(){
        System.out.println("Press 'Enter' to continue...");
        kb.next();
    }

    private static boolean playAgain()
    {
        char again;

        System.out.println("Play again (y/n)?");
        again = kb.next().charAt(0);

        return (again == 'Y' || again == 'y');
    }//end playAgain method

    private static boolean playerChoice() {


        return false;
    }

    private static boolean battle( Monster m){
        char pause = 'p';

        System.out.println("-- A wild " + m.getName() + " appears! --");

        pause();

        System.out.println(hero.getName() + " battles " +
                m.getName());
        System.out.println("---------------------------------------------");

        //do battle
        while (hero.isAlive() && m.isAlive() && pause != 'q')
        {
            //hero goes first
            hero.battleChoices(theMonster);

            //monster's turn (provided it's still alive!)
            if (m.isAlive())
                m.attack(hero);

            //let the player bail out if desired
            System.out.print("\n-->q to quit, any other key to continue: ");
            pause = kb.next().charAt(0);

        }//end battle loop

        if (!m.isAlive()) {
            System.out.println(theHero.getName() + " was victorious!");

        }
        else if (!theHero.isAlive()) {
            System.out.println(theHero.getName() + " was defeated :-(");
            return false;
        }
        else//both are alive so user quit the game
            System.out.println("Quitters never win ;-)");

        return true;

    }//end battle method

    private static void pickUpItem(){
        if( thereIsItem() ){
            Item i = level1.takeItem(x,y);
            hero.getItem(i);
            pause();
        }else{
            System.out.println("There is no item to pick up in this room.");
        }
    }




}
