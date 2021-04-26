import java.util.*;
import java.util.ArrayList;
//import java.sql.*;

class Main {
  public static void printArray(ArrayList<Character> array) {
    for(int i = 0; i < array.size(); i++) {
      System.out.print(array.get(i));
    }
    System.out.println();
  }

  public static void main(String[] args) {
    //Connection c = null;
    Scanner scan = new Scanner(System.in);
    String ans = "test word";
    ArrayList<Character> guessWord = new ArrayList<Character>(1);
    ArrayList<Character> guesedLetters = new ArrayList<Character>(1);
    char guess;
    int fails = 0;
    boolean win = false;

    // //acces sql
    // Class.forName("org.sqlite.replit");
    // c = DriverManager.getConnection("hangeman.db");

    //add word sequence
    for(int i = 0; i < ans.length(); i++) {
      if(ans.charAt(i) == ' ') {
        guessWord.add(' ');
      } else {
        guessWord.add('_');
      }
    }

    // askii art
    System.out.println("|--|");
    System.out.println("|");
    System.out.println("|");
    System.out.println("|");
    printArray(guessWord);
    System.out.println();

    while (fails < 6 && win != true) {
      boolean fail = true;
      int correct = 0;

      // guess
      System.out.print("What is your guess? ");
      guess = scan.next().charAt(0);

      // check for correct
      for (int i = 0; i < ans.length(); i++) {
        if (ans.charAt(i) == guess) {
          guessWord.set(i, guess);
          fail = false;
        }
      }

      //cheack for used
      for(int i = 0; i < guesedLetters.size(); i++) {
        if(guess == guesedLetters.get(i)) {
          fail = false;
          //guessed = true;
        }
      }

      if (fail) {
        fails++;
      }

      //cheack if the word is correct
      for(int i = 0; i < ans.length(); i++) {
        if(ans.charAt(i) == guessWord.get(i)) {
          correct++;
        }
      }
      if(correct == ans.length()) {
        win = true;
      }

      // print hangman
      switch (fails) {
      case 1:
        System.out.println("|--|");
        System.out.println("|  O");
        System.out.println("|");
        System.out.println("|");
        break;
      case 2:
        System.out.println("|--|");
        System.out.println("|  O");
        System.out.println("|  |");
        System.out.println("|");
        break;
      case 3:
        System.out.println("|--|");
        System.out.println("|  O");
        System.out.println("| /|");
        System.out.println("|");
        break;
      case 4:
        System.out.println("|--|");
        System.out.println("|  O");
        System.out.println("| /|\\");
        System.out.println("|");
        break;
      case 5:
        System.out.println("|--|");
        System.out.println("|  O");
        System.out.println("| /|\\");
        System.out.println("| /");
        break;
      case 6:
        System.out.println("|--|");
        System.out.println("|  O");
        System.out.println("| /|\\");
        System.out.println("| / \\");
        break;
      default:
        System.out.println("|--|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
      }

      //System.out.println(guessWord);
      printArray(guessWord);
      guesedLetters.add(guess);
    }

    if (win) {
      System.out.println();
      System.out.println("You Win!");
    } else {
      System.out.println();
      System.out.println("The word was:");
      System.out.println(ans);
    }
  }
}
