import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tester {

    public static void main(String args[]) throws FileNotFoundException {

        String input;
        Master master = new Master();

        System.out.println("Hello. Welcome to Flashcards. " +
                "\nTo create a new Flashcard, enter in 'flash' at any time. " +
                "\nTo read in a File enter 'read'" +
                "\nTo search for a pattern within Flashcards enter 'search'" +
                "\nTo begin study, just enter 'study' at anytime." +
                "\nTo exit the program, 'exit'");

        Scanner in = new Scanner(System.in);
        input = in.nextLine();


        while (!input.equals("exit")) {

            if (input.toLowerCase().equals("flash")) {
                master.CreateFlashCard();
                input = "";

            } else if (input.toLowerCase().equals("study")) {
                System.out.println("\nStudy initiated! Good luck");
                master.studyPromt();
                input = "";

            } else if (input.toLowerCase().equals("read")) {
                System.out.println("Please type the file name you wish to read");
                String fileName = in.nextLine();

                System.out.println("Reading in File.....");
                master.readFile(fileName);
                System.out.println("\nFile read completely." +
                        "\nTotal of " + master.getCount() + " cards created.\n");
                input = "";

            } else if (input.toLowerCase().equals("search")) {
                System.out.println("Please enter in pattern to search for");
                String pattern = in.nextLine();
                System.out.println(master.getCardsWith(pattern).toString());
                input = "";

            } else {
                System.out.println("Please make another selection: \nFLash, Read, Search, Study, Exit");
                input = in.nextLine();

            }
        }

        System.exit(0);


    }
}
