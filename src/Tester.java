import java.util.Scanner;
public class Tester {

    public static void main(String args[]){

        String input ="";
        Master master = new Master();

        System.out.println("Hello. Welcome to Flashcards. \nTo create a new Flashcard, enter in 'Flashcard' at any time. \nTo begin study, just enter" +
                "'study' at anytime.\nTo exit the program, 'exit'");

        Scanner in = new Scanner(System.in);
        input =  in.nextLine();


        while(!input.equals("exit")){

            if(input.toLowerCase().equals("flashcard")){
                master.CreateFlashCard();
                input="";

            }
            else if(input.toLowerCase().equals("study")){
                System.out.println("Study initiated! Good luck");
                input="";

            }
            else{
                System.out.println("Please make another selection: \nFlashcaard,study,exit");
                input = in.nextLine();

            }
        }

        System.exit(0);


    }
}
