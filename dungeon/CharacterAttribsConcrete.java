package dungeon;

public class CharacterAttribsConcrete implements  CharacterAttribs{

    private String name;
    private int attackSpeed;
    private String attackType;
    private double chanceToHit;
    private int damageMin, damageMax;
    private Character symbol;

    public CharacterAttribsConcrete(String n, String atkType, double chance, int atkSpeed, int dmgMin, int dmgMax, Character sym){
        this.name = n;
        this.attackSpeed= atkSpeed;
        this.attackType = atkType;
        this.chanceToHit = chance;
        this.damageMin = dmgMin;
        this.damageMax = dmgMax;
        this.symbol = sym;
    }

    public String getName() {
        return this.name;
    }

    public String getAttackType() {
        return this.attackType;
    }

    public double getChanceToHit() {
        return this.chanceToHit;
    }

    public int getAttackSpeed() {
        return this.attackSpeed;
    }

    public int getDamageMin() {
        return this.damageMin;
    }

    public int getDamageMax() {
        return this.damageMax;
    }

    public Character getSymbol() {
        return this.symbol;
    }

    public void setDamageMinMax(int min, int max){
        this.damageMin = min;
        this.damageMax = max;
    }

    public void setName(String n){
        this.name = n;
    }
}
