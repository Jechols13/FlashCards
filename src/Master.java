import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;

public class Master {

    private Box box1 = new Box(1);
    private Box box2 = new Box(2);
    private Box box3 = new Box(3);
    private Box box4 = new Box(4);
    private Box box5 = new Box(5);
    private FlashCard x;

    private String front = "";
    private String back = "";

    private int count=0;

    Scanner in = new Scanner(System.in);

    /**
     * Creates new Flashcard
     */

    public void CreateFlashCard() {
        System.out.println("Please enter in the front of the card:");
        front = in.nextLine();
        System.out.println("Please enter in the back of the card:");
        back = in.nextLine();
        x = new FlashCard(front, back);
        box1.addFlashcard(x);
    }

    /**
     * Check to see if any Flashcards have been made.
     * if not then return to previous screen
     * If there are some then continue to studying
     */
    public void studyPromt() {

        if (box5.getFlashcards().size() == 0 && box4.getFlashcards().size() == 0 && box3.getFlashcards().size() == 0
                && box2.getFlashcards().size() == 0 && box1.getFlashcards().size() == 0) {
            System.out.println("Oops. Looks like you dont have any Flashcards yet!");
        } else {
            System.out.println("Welcome to your study session! Here are a few rules" +
                    "\n------------------------------------>" +
                    "\n------------------------------------>" +
                    "\nEnter in any of the following at any point in time:" +
                    "\na) Flip Card (show answer)" +
                    "\nb) Know the answer" +
                    "\nc) Dont know the answer" +
                    "\nd) exit");
            Study();
        }
    }


    /**
     * Randomly selects flashcard to study.
     */
    public void Study() {

        int boxRand = (int) (Math.random() * 100);
        int cardRand;
//        System.out.print(boxRand + "\n");

        if (boxRand > 50 && box1.getFlashcards().size() > 0) {
            cardRand = (int) (Math.random() * box1.getFlashcards().size());
            quizMe(box1.getFlashcards().get(cardRand), box1, box1.getFlashcards().get(cardRand).getFront(), box1.getFlashcards().get(cardRand).getBack());

        } else if (boxRand < 50 && boxRand > 25 && box2.getFlashcards().size() > 0) {
            cardRand = (int) (Math.random() * box2.getFlashcards().size());
            quizMe(box2.getFlashcards().get(cardRand), box2, box2.getFlashcards().get(cardRand).getFront(), box2.getFlashcards().get(cardRand).getBack());


        } else if (boxRand < 25 && boxRand > 12 && box3.getFlashcards().size() > 0) {
            cardRand = (int) (Math.random() * box3.getFlashcards().size());
            quizMe(box3.getFlashcards().get(cardRand), box3, box3.getFlashcards().get(cardRand).getFront(), box3.getFlashcards().get(cardRand).getBack());

        } else if (boxRand < 12 && boxRand > 6 && box4.getFlashcards().size() > 0) {
            cardRand = (int) (Math.random() * box4.getFlashcards().size());
            quizMe(box4.getFlashcards().get(cardRand), box4, box4.getFlashcards().get(cardRand).getFront(), box4.getFlashcards().get(cardRand).getBack());


        } else if (boxRand < 6 && box5.getFlashcards().size() > 0) {
            cardRand = (int) (Math.random() * box5.getFlashcards().size());
            quizMe(box5.getFlashcards().get(cardRand), box5, box5.getFlashcards().get(cardRand).getFront(), box5.getFlashcards().get(cardRand).getBack());


        } else {
            Study();
        }

    }

    /**
     * Checks knowledge of flashcard selected
     * Randomly chooses front or back of card for reference
     * User then makes a choice
     */

    public void quizMe(FlashCard f, Box b, String front, String back) {
        String ans;
        String show;
        int i = (int) Math.random() * 10;

        if (i > 5) {
            ans = front;
            show = back;
        } else {
            ans = back;
            show = front;
        }

        System.out.println("What is the meaning of: " + show);

        boolean startSwitch = true;

//IF user chooses to exit, study process will be halted. Else study as long as wish.
        if (startSwitch) {
            switch (in.nextLine()) {
                case "a":
                    System.out.println("The answer is: " + ans);
                    System.out.println("\nLets try again!");
                    break;
                case "b":
                    System.out.println("Great! Whats the answer?");
                    String guess = in.nextLine();
                    if (guess.toLowerCase().equals(ans.toLowerCase())) {
                        System.out.println("Great that's correct! :)");
                        moveForward(f, b);
                    } else {
                        System.out.println("Sorry, that's incorrect :(");
                        moveBack(f, b);
                    }
                    break;
                case "c":
                    System.out.println("The answer is: " + ans);
                    System.out.println("\nStudy this one a bit more!");
                    moveBack(f, b);
                    break;
                case "d":
                    System.out.println("You have chosen to end the Study session.");
                    startSwitch = false;
                    break;
                default:
                    System.out.println("Invalid option. Please choose between: " +
                            "\nEnter in any of the following at any point in time:" +
                            "\na) Flip Card (show answer)" +
                            "\nb) Know the answer" +
                            "\nc) Dont know the answer" +
                            "\nd) exit");
            }
            if (startSwitch) {
                Study();
            } else {

            }
        }

    }

    public void moveForward(FlashCard f, Box b) {
        if (b.id() == 1) {
            b.deleteFlashcard(f);
            box2.addFlashcard(f);
        } else if (b.id() == 2) {
            b.deleteFlashcard(f);
            box3.addFlashcard(f);
        } else if (b.id() == 3) {
            b.deleteFlashcard(f);
            box4.addFlashcard(f);
        } else if (b.id() == 4) {
            b.deleteFlashcard(f);
            box5.addFlashcard(f);
        } else {

        }
    }

    public void moveBack(FlashCard f, Box b) {
        if (b.id() == 2) {
            b.deleteFlashcard(f);
            box1.addFlashcard(f);
        } else if (b.id() == 3) {
            b.deleteFlashcard(f);
            box2.addFlashcard(f);
        } else if (b.id() == 4) {
            b.deleteFlashcard(f);
            box3.addFlashcard(f);
        } else if (b.id() == 5) {
            b.deleteFlashcard(f);
            box4.addFlashcard(f);
        } else {

        }

    }

    public void readFile(String fileName) throws FileNotFoundException {
        File f = new File(fileName);
        Scanner in = new Scanner(f);
        in.useDelimiter(" \n");
        while (in.hasNext()) {
            this.front = in.nextLine();
            if (!(front.equals(""))) {
                this.back = in.nextLine();
                this.x = new FlashCard(this.front, this.back);
                this.box1.addFlashcard(this.x);
                count++;
            }
        }
        in.close();
    }

    public ArrayList<FlashCard> getCardsWith(String pattern) {
        assert pattern != null || pattern != "";
        ArrayList<FlashCard> matches = new ArrayList<FlashCard>();
        Stack<Box> all = new Stack<Box>();
        if (box5.getFlashcards().size() == 0 && box4.getFlashcards().size() == 0 && box3.getFlashcards().size() == 0
                && box2.getFlashcards().size() == 0 && box1.getFlashcards().size() == 0) {
            System.out.println("Oops. Looks like you dont have any Flashcards yet!");
        } else {

            //Push all boxes into a stack.
            all.push(box1);
            all.push(box2);
            all.push(box3);
            all.push(box4);
            all.push(box5);

            // Iterate through stack then iterate through cards to find matches.
            for (Box x : all) {
                for (FlashCard y : x.getFlashcards()) {
                    if (y.getFront().toLowerCase().matches(pattern.toLowerCase()) || y.getBack().toLowerCase().matches(pattern.toLowerCase())) {
                        matches.add(y);
                    }
                }
            }
        }
        return matches;
    }

    public int getCount(){
        return this.count;
    }
}