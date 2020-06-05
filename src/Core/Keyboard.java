package Core;

import java.util.Scanner;

public class Keyboard {

    private static Scanner kb;

    private static void initKB() {
        if (kb == null)
            kb = new Scanner(System.in);
    }

    public static String readString() {
        initKB();
        return kb.nextLine();
    }

    public static char readChar() {
        initKB();
        char c=' ';
        String temp = kb.nextLine();
        if(!temp.isEmpty())
            c = temp.charAt(0);

        return c;
    }

    public static int readInt() {
        initKB();
        return kb.nextInt();
    }
}
