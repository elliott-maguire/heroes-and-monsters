package Character.Hero;

public class HeroFactory {
    
    public static Hero createSorceress() {
        return new Sorceress();
    }

    public static Hero createThief() {
        return new Thief();
    }

    public static Hero createWarrior() {
        return new Warrior();
    }
}