package adventure.Dungeon;

import adventure.Character.Hero.Hero;
import adventure.Character.Hero.HeroFactory;
import adventure.Character.Monster.Monster;
import adventure.Item.Item;

import java.util.Random;
import java.util.Scanner;

public class DungeonAdventure {

    private static final int _CHEAT = 1337;
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
                "4. Paladin\n" +
                "5. Wizard\n" );


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

    private static boolean playerTakeTurn() {
        if(thereIsItem()){
            pickUpItem();
        }
        if(checkForFight()) {

            System.out.println("What would you like to do?");
            System.out.println("1) Move");
            System.out.println("2) Use Health Potion");
            System.out.println("3) Use Vision Potion");
            System.out.println("4) Pillars of OO");
            int x = kb.nextInt();

            switch (x) {
                case 1:
                    movePlayer();
                    return true;
                case 2:
                    hero.useHealthPotion();
                    return true;
                case 3:
                    hero.useVisionPotion();
                    return true;
                case 4:
                    hero.readPillars();
                    return true;
                case _CHEAT:
                    cheatMenu();
                    return true;
            }
        }

        return false;
    }

    private static void cheatMenu() {
    }

    private static void draw(){
        drawHeroView();
        System.out.println( "--x:" + x + " y:" + y + "--");
        System.out.println( hero.toString() );
    }

    private static void drawHeroView() {

        switch (hero.getVisionLevel()){
            case 0:
                level1.drawRoom(x,y);
                break;
            case 1:
                level1.drawExtendedView(x,y);
                hero.setVisionLevel(0);
                break;
            default:
                level1.drawBoard();
        }

    }

    private static void enterRoom(){
        level1.enterRoom( x, y , hero);
    }

    private static void leaveRoom(){
        level1.leaveRoom();
    }

    private static boolean checkForFight(){
        boolean win = true;
        if (level1.hasMonster(x,y)) {
            Monster m = level1.getMonster(x,y);
            if (m.isAlive()) {
                win = battle(level1.getMonster(x, y));
                draw();
            }
        }
        return win;
    }

    private static void movePlayer(){
        int c = 0;

        do {
            System.out.println("Move:");
            System.out.println("1) North");
            System.out.println("2) South");
            System.out.println("3) West");
            System.out.println("4) East");

            c = kb.nextInt();
        }while(c < 4 && c > 0);



        switch(c){
            case 1:
                if( x != 0 ){
                    x--;
                }
                break;
            case 2:
                if( x != Dungeon._ROW-1 ){
                    x++;
                }
                break;
            case 3:
                if( y != 0 ) {
                    y--;
                }
                break;
            case 4:
                if( y != Dungeon._COL-1 ) {
                    y++;
                }
                break;

        }

            leaveRoom();
            enterRoom();

    }

    private static void spawnPlayer(){
        Random rand = new Random();

        x = rand.nextInt(level1._ROW);
        y = rand.nextInt(level1._COL);

        enterRoom();
    }

    private static boolean thereIsItem(){
        return level1.itemInRoom( x, y );
    }

    public static void gameLoop(){



        do{
            initializeFields();
            spawnPlayer();

            do {
                draw();
            }while(playerTakeTurn());

        }while(playAgain());

    }
    private static void pause(){
        System.out.println("Press 'Enter' to continue...");
        kb.next();
    }

    private static boolean playAgain() {
        char again;

        System.out.println("Play again (y/n)?");
        again = kb.next().charAt(0);

        return (again == 'Y' || again == 'y');
    }

    private static void battleChoicesInput(Monster opponent){
        int choice;
        int numTurns =1;

        System.out.println("1. Attack Opponent");
        System.out.print("2. ");
        hero.getSpecialAction().printName();
        System.out.println("3. Use Health Potion");
        System.out.print("\nChoose an option: ");
        choice = kb.nextInt();

        switch (choice) {
            case 1:
                hero.doMainAttack(opponent);
                break;
            case 2:
                hero.doSpecialAttack(opponent);
                break;
            case 3:
                hero.useHealthPotion();
                break;
            default:
                System.out.println("invalid choice!");
        }

        numTurns--;
        if (numTurns > 0)
            System.out.println("Number of turns remaining is: " + numTurns);


    }

    private static void battleChoices(Monster opponent) {
        int numTurns = 1;
        do{
            battleChoicesInput(opponent);
        }while(numTurns > 0);
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
            battleChoices(m);

            //monster's turn (provided it's still alive!)
            if (m.isAlive())
                m.doMainAttack(hero);

            //let the player bail out if desired
            System.out.print("\n-->q to quit, any other key to continue: ");
            pause = kb.next().charAt(0);

        }//end battle loop

        if (!m.isAlive()) {
            System.out.println(hero.getName() + " was victorious!");

        }
        else if (!hero.isAlive()) {
            System.out.println(hero.getName() + " was defeated :-(");
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
