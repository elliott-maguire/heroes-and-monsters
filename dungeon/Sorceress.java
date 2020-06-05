package dungeon;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */



public class Sorceress extends Hero
{
	public final int MIN_ADD = 25;
	public final int MAX_ADD = 50;


    public Sorceress()
	{
		super("Sorceress", 75, 5, .7, 25, 50, .3, "casts a spell of fireball at", "Increase Hit Points");


    }//end constructor


	public void altAttack(DungeonCharacter opponent)
    {
	    int hPoints;

		hPoints = (int)(Math.random() * (MAX_ADD - MIN_ADD + 1)) + MIN_ADD;
		addHitPoints(hPoints);
		System.out.println(this.getName() + " added [" + hPoints + "] points.\n"
							+ "Total hit points remaining are: "
							+ hitPoints);
		 System.out.println();

	}
	
	@Override
	public boolean loopCondition(DungeonCharacter opponent)
	{
		return ( hitPoints > 0 && opponent.getHitPoints() > 0 );
	}

	

}//end class