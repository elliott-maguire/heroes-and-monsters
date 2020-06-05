package dungeon;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */




public class Warrior extends Hero
{

    public Warrior()
	{

		super("Warrior", 125, 4, .8, 35, 60, .2, "swings a mighty sword at", "Crushing Blow on Opponent");


    }//end constructor

	public void altAttack(DungeonCharacter opponent)
	{
		if (Math.random() <= .4)
		{
			int blowPoints = (int)(Math.random() * 76) + 100;
			System.out.println(this.getName() + " lands a CRUSHING BLOW for " + blowPoints
								+ " damage!");
			opponent.subtractHitPoints(blowPoints);
		}//end blow succeeded
		else
		{
			System.out.println(this.getName() + " failed to land a crushing blow");
			System.out.println();
		}//blow failed

	}


}//end Hero class