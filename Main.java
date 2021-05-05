import java.util.*;
import java.util.ArrayList;
import java.util.Random;

class Main {
  public static void printArray(ArrayList<Character> array) {
    for(int i = 0; i < array.size(); i++) {
      System.out.print(array.get(i));
    }
    System.out.println();
  }

  public static void main(String[] args) {
    //asign words
    String[] Easy = {"bell", "blue", "fireworks", "flag", "hat", "heart", "ice cream", "panic", "pie", "red", "rocket", "star", "statue", "stripes", "white", "wreath", "boat", "chosen", "crowed", "heal"};
    String[] Medium = {"abash", "abate", "basin", "bemoan", "canny", "capable", "capablity", "decipher", "defunct", "efficent", "elliptical", "finance", "frugality", "gregarious", "habitat", "hereditary", "hybrid", "immerse", "immigrant", "jurisdiction", "kaleidoscope"};
    String[] Hard = {"affix", "askew", "bagpipes", "bandwagon", "crypt", "cycle", "dirndl", "daiquiri", "embezzle", "equip", "facking", "fishhook", "gossip", "galaxy", "haiku", "haphazard", "injury", "jazziest", "jinx", "knapsack"};

    //asign variables
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    String ans = "test word";
    ArrayList<Character> guessWord = new ArrayList<Character>(1);
    ArrayList<Character> guesedLetters = new ArrayList<Character>(1);
    char guess;
    char level;
    int fails = 0;
    int randomNum;
    boolean win = false;

    //start game and ask for level
    System.out.println("Welcome to Hange Man!!");
    System.out.println("Pick a Level: \nEasy\nMedium\nHard");
    level = scan.next().charAt(0);
    while(level != 'E' && level != 'e' && level != 'M' && level != 'm' && level != 'H' && level != 'h') {
      level = scan.next().charAt(0);
    }

    //cheak level
    randomNum = rand.nextInt(19);
    if(level == 'E' || level == 'e') {
      ans = Easy[randomNum];
    } else if(level == 'M' || level == 'm') {
      ans = Medium[randomNum];
    } else if(level == 'H' || level == 'h') {
      ans = Hard[randomNum];
    }

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
