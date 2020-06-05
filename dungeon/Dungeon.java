package dungeon;

import java.io.*;
import java.util.HashMap;
import java.util.Random;

public class Dungeon {

	private static String SAVE_FILE = "dungeonAdventure.save";
	private static Random rand;
	private static final int _CHEAT = 1337;
	private static boolean showFullMap = false;
	private static Hero theHero;

	private static void init(){
		Keyboard.init();
		Level.init();
		rand = new Random();
	}

	private static void cheatMenu(){
		int x = 0;

		do {
			System.out.println("<x-x-x-x-x-x-x-x-x-x-x-x-x->");
			System.out.println("<x-x-x-x-CHEAT MENU-x-x-x-->");
			System.out.println("<--CHEATERS NEVER PROSPER-->");
			System.out.println("<----PRESS '0' TO EXIT----->");
			System.out.println("1) Give hero 1 health potion");
			System.out.println("2) Give hero 5 health potions");
			System.out.println("3) Give hero 1 vision potion");
			System.out.println("4) Give hero 5 vision potions");
			System.out.println("5) Set hero's min max damage to 500-550");
			System.out.println("6) Set hero HP to 1");
			System.out.println("7) Toggle showFullMap");
			System.out.println("8) Force Populate Map (will populate map with Monsters and Items.)");
			System.out.println("9) Re initialize map.");
			System.out.println("<----PRESS '0' TO EXIT----->");
			System.out.println(theHero.status());
			x = Keyboard.readInt();

			switch (x) {
				case 1:
					giveHealthPot();
					break;
				case 2:
					give5HealthPots();
					break;
				case 3:
					giveVisionPot();
					break;
				case 4:
					give5VisionPotions();
					break;
				case 5:
					theHero.setDamageMinMax(500,550);
					System.out.println("Hero damage set to 500-550!");
					pause();
					break;
				case 6:
					theHero.setHP(1);
					break;
				case 7:
					showFullMap = !showFullMap;
					System.out.println("showFullMap: " + (showFullMap ? "ON": "OFF") );
					pause();
					break;
				case 8:
					Level.FORCE_Populate();
					System.out.println("Level populate completed!");
					pause();
					break;
				case 9:
					Level.init();
					System.out.println("Level re-initialized!");
					pause();
					break;
			}

		}while(x != 0);
	}

	private static void giveHealthPot(){
		theHero.giveItem( IFactory.HP.make() );
	}

	private static void give5HealthPots(){
		for(int i = 0; i < 5; i++){
			giveHealthPot();
		}
	}

	private static void giveVisionPot(){
		theHero.giveItem( IFactory.VP.make() );
	}

	private static void give5VisionPotions(){
		for(int i = 0; i < 5; i++){
			giveVisionPot();
		}
	}

	private static void drawHeroView(){

		if(theHero.getVision() > 1 || showFullMap){
			Level.drawView();
		}
		else {
			Level.drawRoom( theHero.x(), theHero.y() );
		}

	}

	public static void gameLoop(){


		do
		{
			init();
			theHero = chooseHero();
			spawnPlayer();

			do {
				draw();
			}while(playerTakeTurn());

		} while (playAgain());

	}

	private static boolean thereIsItem(){
		return Level.itemInRoom( theHero.x(), theHero.y() );
	}

	private static void pause(){
		System.out.println("Press 'Enter' to continue...");
		Keyboard.readString(); Keyboard.readString();
	}

	private static void pickUpItem(){
		if( thereIsItem() ){
			theHero.giveItem( Level.takeItem( theHero.x() ,theHero.y() ) );
			pause();
		}else{
			System.out.println("There is no item to pick up in this room.");
		}
	}

	private static void useItem(){
		System.out.println("Inventory:");
		theHero.listInventory();

		System.out.println("\n0) Cancel");
		System.out.println( "Select an item you like would to use:" );

		int input = Keyboard.readInt();

		if(input > 0) {
			theHero.useItem(input);
			pause();
		}

	}

	private static boolean playerTakeTurn() {
		if(thereIsItem()){
			pickUpItem();
		}
		if(checkAndInitFight()) {

			System.out.println("What would you like to do?");
			System.out.println("1) Move");
			System.out.println("2) Use item");
			System.out.println("3) Save game");
			System.out.println("4) Load game");
			int x = Keyboard.readInt();

			switch (x) {
				case 1:
					movePlayer();
					return true;
				case 2:
					useItem();
					return true;
				case 3:
					saveGame();
					return true;
				case 4:
					loadGame();
					return true;
				case _CHEAT:
					cheatMenu();
					return true;
			}
		}

		return false;
	}

	private static void draw(){
		drawHeroView();
		System.out.println( "--x:" + theHero.x() + " y:" + theHero.y() + "--");
		System.out.println( theHero.status() );
	}

	private static void enterRoom(){
		Level.enterRoom( theHero.x(), theHero.y() );
	}

	private static void leaveRoom(){
		Level.leaveRoom( theHero.x(), theHero.y() );
	}

	private static boolean checkAndInitFight(){
		boolean win = true;
		if( !Level.isVacant(theHero.x(), theHero.y()) ){
			win = battle(theHero, Level.getMonster(theHero.x(), theHero.y()) );
			draw();
		}
		return win;
	}

	private static void movePlayer(){

		System.out.println("Move:");
		System.out.println("1) North");
		System.out.println("2) South");
		System.out.println("3) West");
		System.out.println("4) East");

		int c = Keyboard.readInt();
		int x = theHero.x();
		int y = theHero.y();

		switch(c){
			case 1:
				if( x != 0 ){
					x--;
				}
				break;
			case 2:
				if( x != Level._ROWS-1 ){
					x++;
				}
				break;
			case 3:
				if( y != 0 ) {
					y--;
				}
				break;
			case 4:
				if( y != Level._COL-1 ) {
					y++;
				}
				break;

		}

		if( x != theHero.x() || y != theHero.y() ){
			leaveRoom();
			theHero.setX(x);
			theHero.setY(y);
			enterRoom();
		}

	}

	private static void spawnPlayer(){
		theHero.setX( rand.nextInt( Level._ROWS ) );
		theHero.setY( rand.nextInt( Level._COL  ) );
		enterRoom();
	}

	private static Hero chooseHero()
	{
		int choice;
		Hero theHero;

		System.out.println("Choose a hero:\n" +
				"1. Warrior\n" +
				"2. Sorceress\n" +
				"3. Thief");
		choice = Keyboard.readInt();

		switch(choice)
		{
			case 1: return HFactory.WARRIOR.make();

			case 2: return HFactory.SORCERESS.make();

			case 3: return HFactory.THEIF.make();

			default:
				Hero h = HFactory.rand();
				System.out.println( "invalid choice, returning " + h.getClass() );
				return h;
		}//end switch
	}//end chooseHero method


	private static boolean playAgain()
	{
		char again;

		System.out.println("Play again (y/n)?");
		again = Keyboard.readChar();

		return (again == 'Y' || again == 'y');
	}//end playAgain method


	private static boolean battle(Hero theHero, Monster theMonster){
		char pause = 'p';

		System.out.println("-- A wild " + theMonster.getName() + " appears! --");

		pause();

		System.out.println(theHero.getName() + " battles " +
				theMonster.getName());
		System.out.println("---------------------------------------------");

		//do battle
		while (theHero.isAlive() && theMonster.isAlive() && pause != 'q')
		{
			//hero goes first
			theHero.battleChoices(theMonster);

			//monster's turn (provided it's still alive!)
			if (theMonster.isAlive())
				theMonster.attack(theHero);

			//let the player bail out if desired
			System.out.print("\n-->q to quit, any other key to continue: ");
			pause = Keyboard.readChar();

		}//end battle loop

		if (!theMonster.isAlive()) {
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

	private static void saveGame(){
		try {
			FileOutputStream savefile = new FileOutputStream(SAVE_FILE);
			ObjectOutputStream outObj = new ObjectOutputStream(savefile);

			outObj.writeObject( Level.getMap() );
			outObj.writeObject( theHero );

			outObj.flush();
			outObj.close();
			savefile.close();

		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

	private static void loadGame(){
		try{

			FileInputStream In = new FileInputStream(SAVE_FILE);
			ObjectInputStream objIn = new ObjectInputStream(In);

			Level.setMap((HashMap<Integer, Room>) objIn.readObject());
			theHero = (Hero) objIn.readObject();

		}catch(IOException | ClassNotFoundException e){
			e.printStackTrace();
		}
	}


}//end Dungeon class