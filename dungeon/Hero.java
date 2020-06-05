package dungeon;

import java.util.ArrayList;


public abstract class Hero extends DungeonCharacter
{
	protected double chanceToBlock;
	protected int numTurns;
	protected String attack2;

	private static final int MAX_VISION = 15;
	private static final int MIN_VISION = 1;

	private static int pos_x;
	private static int pos_y;

	private ArrayList<Item> inventory;


  public Hero(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax,
					 double chanceToBlock, String attackType, String a2)
  {
	super(name, hitPoints, attackSpeed, chanceToHit, damageMin, damageMax, attackType,'&');
	this.chanceToBlock = chanceToBlock;
	this.attack2 = a2;
	readName();
	this.inventory = new ArrayList<Item>();
  }

  public void giveItem(Item obj){
  	this.inventory.add(obj);
  	System.out.println(this.getName() + " received an item: " + obj.getName() + ".");
  }

  public void listInventory(){
  	int i = 0;

  	for(Item itm : this.inventory){
  		i++;
  		System.out.println( i + ") " + itm.getName() );
	}

  }



  public void readName()
  {
	  	Keyboard.readString();
		System.out.print("Enter character name: ");
		this.setName( Keyboard.readString() );
  }

	public void setHP(int newHP){
		this.hitPoints = newHP;
	}

	public int getHP(){
  		return this.hitPoints;
	}

	public String status(){
  		String temp = "";

  		int potions = 0;
  		int pillars = 0;
		int vision = 0;

		for(Item i: this.inventory){
			if(i.getSymbol() == 'H'){
				potions++;
			}else if(i.getSymbol() == 'P'){
				pillars++;
			}else if(i.getSymbol() == 'V'){
				vision++;
			}
		}

  		temp += "( HP: " + this.hitPoints +" ) ";
  		temp += "[ Health Potion(s): " + potions + " ] ";
  		temp += "< Vision Potion(s): " + vision  + " > ";
  		temp += "|| Pillars Found: " + pillars + " ||";

  		return temp;
	}

	//will reset vision to default once read, to simulate effect wearing off
	public int getVision(){
		int x = this.vision;

		if(this.vision>1)
			this.vision = 1;

		return x;
	}

	public void setVision(int x){
		if(x > 1 || x < 20)
			this.vision = x;
	}

	public void useItem( int i ){
		i--;

		if( i >= 0 && i <= this.inventory.size() ){
			if( this.inventory.get(i).use(this ) ){
				this.inventory.remove(i);

			}
		}

	}

  public abstract void altAttack(DungeonCharacter opponent);


  public boolean defend()
  {
		return Math.random() <= chanceToBlock;

  }//end defend method


public void subtractHitPoints(int hitPoints)
	{
		if (defend())
		{
			System.out.println(this.getName() + " BLOCKED the attack!");
		}
		else
		{
			super.subtractHitPoints(hitPoints);
		}


	}//end method

	public int x(){
  		return this.pos_x;
	}

	public int y(){
  		return this.pos_y;
	}

	public void setX(int n){
  		this.pos_x = n;
	}

	public void setY(int n){
		this.pos_y = n;
	}
	
	public boolean loopCondition(DungeonCharacter opponent)
	{
		return true;
	}

	public void battleChoices(DungeonCharacter opponent)
	{
	    numTurns = this.getAttackSpeed()/opponent.getAttackSpeed();

		if (numTurns == 0)
			numTurns++;

		System.out.println("Number of turns this round is: " + numTurns);

		int choice;

		do
		{
		    System.out.println("1. Attack Opponent");
		    System.out.println("2. " + this.attack2);
		    System.out.print("Choose an option: ");
		    choice = Keyboard.readInt();

		    switch (choice)
		    {
			    case 1: attack(opponent);
			        break;
			    case 2: altAttack(opponent);
			        break;
			    default:
			        System.out.println("invalid choice!");
		    }//end switch

			numTurns--;
		    if (numTurns > 0)
			    System.out.println("Number of turns remaining is: " + numTurns);

		} while( numTurns > 0 && loopCondition(opponent) );

	}//end battleChoices

}//end Hero class