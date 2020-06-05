package dungeon;

import java.io.*;
import java.util.*;

public class Keyboard
{

   private static Scanner kb;

   //initializes scanner
   public static void init()
   {
      kb = new Scanner(System.in);
   }

   //-----------------------------------------------------------------
   //  Returns a string read from standard input.
   //-----------------------------------------------------------------
   public static String readString()
   {
      String str = kb.nextLine();
      
      return str;
   }

   //-----------------------------------------------------------------
   //  Returns a character read from standard input.
   //-----------------------------------------------------------------
   public static char readChar()
   {
     
      char value;
      try
      {
         value = kb.nextLine().charAt(0);
      }
      catch (Exception exception)
      {
         value = Character.MIN_VALUE;
      }

      return value;
   }

   //-----------------------------------------------------------------
   //  Returns an integer read from standard input.
   //-----------------------------------------------------------------
   public static int readInt()
   {
      int value;
      try
      {
         value =  kb.nextInt();
      }
      catch (Exception exception)
      {
         value = Integer.MIN_VALUE;
      }
      return value;
   }


}
