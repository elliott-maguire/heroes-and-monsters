
package dungeon;

import java.io.Serializable;

public abstract class DungeonCharacter implements Serializable {

	protected int hitPoints;
	protected int vision;
	private CharacterAttribsConcrete CA;


//-----------------------------------------------------------------
//explicit constructor to initialize instance variables -- it is called
// by derived classes
	public DungeonCharacter(String name, int hitPoints, int attackSpeed,
				     double chanceToHit, int damageMin, int damageMax, String attackT, Character symbol)
	{

		this.CA = CAFactory.getAttack(name, attackT,chanceToHit,attackSpeed,damageMin,damageMax,symbol);
		this.hitPoints = hitPoints;
		this.vision = 1;

	}//end constructor





	public Character getSymbol(){
		return this.CA.getSymbol();
	}

	public String getName()
	{
		return this.CA.getName();
	}
	public int getHitPoints()
	{
		return this.hitPoints;
	}
	public int getAttackSpeed()
	{
		return this.CA.getAttackSpeed();
	}

	public void setName(String n){
		this.CA.setName(n);
	}

	public void addHitPoints(int hitPoints)
	{
		if (hitPoints <=0)
			System.out.println("Hitpoint amount must be positive.");
		else
		{
			this.hitPoints += hitPoints;

		}
	}//end addHitPoints method


public void subtractHitPoints(int hitPoints)
{
	if (hitPoints <0)
		System.out.println("Hitpoint amount must be positive.");
	else if (hitPoints >0)
	{
		this.hitPoints -= hitPoints;
		if (this.hitPoints < 0)
			this.hitPoints = 0;
		System.out.println(getName() + " hit " +
							" for <" + hitPoints + "> points damage.");
		System.out.println(getName() + " now has " +
							getHitPoints() + " hit points remaining.");
		System.out.println();
	}//end else if

	if (this.hitPoints == 0)
		System.out.println(this.getName() + " has been killed :-(");


}//end method

	public void setDamageMinMax(int min, int max){
		CA.setDamageMinMax(min,max);
	}


    public boolean isAlive()
	{
	  return (this.hitPoints > 0);
	}//end isAlive method


	public void attack(DungeonCharacter opponent)
	{	
		if( !this.CA.getAttackType().isEmpty() )
		{
			System.out.println(CA.getName() + " "+ this.CA.getAttackType() +" " +
							opponent.getName() + ":");
		}

		boolean canAttack;
		int damage;

		canAttack = Math.random() <= this.CA.getChanceToHit();

		if (canAttack)
		{
			damage = (int)(Math.random() * (this.CA.getDamageMax() - this.CA.getDamageMin() + 1))
						+ this.CA.getDamageMin() ;
			opponent.subtractHitPoints(damage);



			System.out.println();
		}//end if can attack
		else
		{

			System.out.println(getName() + "'s attack on " + opponent.getName() +
								" failed!");
			System.out.println();
		}//end else

	}//end attack method

//-----------------------------------------------------------------



}//end class Character

