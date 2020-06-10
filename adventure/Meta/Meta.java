package adventure.Meta;

public class Meta {
    private final String type;
    private final int maxHealth;

    private final int strength;
    private final int defense;
    private final int speed;

    public Meta(String type, int maxHealth, int strength, int defense, int speed) {
        this.type = type;
        this.maxHealth = maxHealth;
        this.strength = strength;
        this.defense = defense;
        this.speed = speed;
    }

    public String getType() {
        return type;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getStrength() {
        return strength;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }
}
