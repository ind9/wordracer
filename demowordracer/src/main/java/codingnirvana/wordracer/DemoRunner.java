package codingnirvana.wordracer;

import codingnirvana.wordracer.samples.*;

import java.io.IOException;
import java.util.Scanner;

public class DemoRunner {
    public static void main(String[] args) throws IOException {

        WordRacer dRacer = new DemoWordRacer();

        if (args.length == 1) {
            String type = args[0].trim();
            if (type.equals("M")) {
                dRacer = new MyWordRacer();
            } else if (type.equals("Z")) {
                dRacer = new ZRacer();
            } else if (type.equals("S")) {
                dRacer = new SlowWordRacer();
            } else if (type.equals("R")) {
                dRacer = new RogueWordRacer();
            }
            else {
                dRacer = new GlassRoom();
            }
        }

        Scanner input = new Scanner(System.in);
        char firstLetter = input.nextLine().charAt(0);

        boolean myTurn = input.nextLine().charAt(0) == '1';

        dRacer.initGameBoard(firstLetter);
        char letter;
        for (int i = 0; i < 48; i++) {

            if (myTurn) {
                Result result = dRacer.pickLetter();
                System.out.println(result.Letter + " " + result.Position);
            } else {
                letter = input.nextLine().charAt(0);

                int position = dRacer.pickPosition(letter);
                System.out.println(position);
                System.out.flush();
            }

            myTurn = !myTurn;
        }
    }
}
