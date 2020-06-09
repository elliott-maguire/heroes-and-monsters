package Core;

import Character.Hero.*;
import Character.Monster.*;

public class Main {
    public static void main(String[] args) {
        Hero theHero;
        Monster theMonster;
        do {
            theHero = chooseHero();
            theMonster = MonsterFactory.createRandomMonster();
            battle(theHero, theMonster);
        } while (playAgain());
    }

    public static Hero chooseHero() {
        int choice;
        Hero theHero;

        System.out.println("Choose a hero:\n" + "1. Warrior\n" + "2. Sorceress\n" + "3. Thief");
        choice = Keyboard.readInt();
        switch (choice) {
            case 1:
                return HeroFactory.createWarrior();
            case 2:
                return HeroFactory.createSorceress();
            case 3:
                return HeroFactory.createThief();
            default:
                System.out.println("invalid choice, returning Thief");
                return HeroFactory.createThief();
        }
    }

    public static boolean playAgain() {
        char again;
        System.out.println("Play again (y/n)?");
        again = Keyboard.readChar();
        return (again == 'Y' || again == 'y');
    }

    public static void battle(Hero theHero, Monster theMonster) {
        char pause = 'p';
        System.out.println(theHero.getName() + " battles " + theMonster.getName());
        System.out.println("---------------------------------------------");

        while (theHero.isAlive() && theMonster.isAlive() && pause != 'q') {
            theHero.battleChoices(theMonster);
            if (theMonster.isAlive()) {
                theMonster.attack(theHero);
            }
            System.out.print("\n-->q to quit, anything else to continue: ");
            Keyboard.readString();
            pause = Keyboard.readChar();
        }

        if (!theMonster.isAlive())
            System.out.println(theHero.getName() + " was victorious!");
        else if (!theHero.isAlive())
            System.out.println(theHero.getName() + " was defeated :-(");
        else
            System.out.println("Quitters never win ;-)");
    }
}