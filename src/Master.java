import java.util.Scanner;

public class Master {

    Box box1 = new Box(1);
    Box box2 = new Box(2);
    Box box3 = new Box(3);
    Box box4 = new Box(4);
    Box box5 = new Box(5);
    FlashCard x;


    String input = "";
    String front = "";
    String back = "";

    Scanner in = new Scanner(System.in);

    public void CreateFlashCard(){



        System.out.println("Please enter in the front of the card:");
        front = in.nextLine();
        System.out.println("Please enter in the back of the card:");
        back = in.nextLine();
        x = new FlashCard(front, back);
        box1.addFlashcard(x);
    }

    public void studyPromt(){
        System.out.println("Welcome to your study session! Here are a few rules" +
                "\n------------------------------------>" +
                "\n------------------------------------>" +
                "\nEnter in any of the following at any point in time:" +
                "\na) Flip Card (show answer)"  +
                "\nb) Know the answer" +
                "\nc) Dont know the answer" +
                "\nd) exit");
        Study();
    }

    public void Study(){

        int boxRand = (int) (Math.random()*100);
        int cardRand;
        System.out.print(boxRand + "\n");

        if(boxRand > 50 && box1.getFlashcards().size() > 0){
            cardRand = (int) (Math.random() * box1.getFlashcards().size());
            quizMe(box1.getFlashcards().get(cardRand),box1,box1.getFlashcards().get(cardRand).getFront(),box1.getFlashcards().get(cardRand).getBack());

        }
        else if(boxRand < 50 && boxRand > 25 && box2.getFlashcards().size() > 0){
            cardRand = (int) (Math.random() * box2.getFlashcards().size());
            quizMe(box2.getFlashcards().get(cardRand),box2,box2.getFlashcards().get(cardRand).getFront(),box2.getFlashcards().get(cardRand).getBack());


        }
        else if(boxRand < 25 && boxRand > 12 && box3.getFlashcards().size() > 0){
            cardRand = (int) (Math.random() * box3.getFlashcards().size());
            quizMe(box3.getFlashcards().get(cardRand),box3,box3.getFlashcards().get(cardRand).getFront(),box3.getFlashcards().get(cardRand).getBack());

        }
        else if (boxRand < 12 && boxRand > 6 && box4.getFlashcards().size() > 0){
            cardRand = (int) (Math.random() * box4.getFlashcards().size());
            quizMe(box4.getFlashcards().get(cardRand),box4,box4.getFlashcards().get(cardRand).getFront(),box4.getFlashcards().get(cardRand).getBack());


        }
        else if (boxRand < 6 && box5.getFlashcards().size() > 0){
            cardRand = (int) (Math.random() * box5.getFlashcards().size());
            quizMe(box5.getFlashcards().get(cardRand),box5,box5.getFlashcards().get(cardRand).getFront(),box5.getFlashcards().get(cardRand).getBack());


        }
        else{
            Study();
        }

    }

    public void quizMe(FlashCard f, Box b,String front, String back){
        String ans;
        String show;
        int i = (int) Math.random() *10;

        if(i > 5){
            ans = front;
            show = back;
        }
        else{
            ans = back;
            show = front;
        }

        System.out.println("What is the meaning of: " + show);

        boolean startSwitch = true;
        while(startSwitch) {
            switch (in.nextLine()) {
                case "a":
                    System.out.println("The answer is: " + ans);
                    System.out.println("\nLets try again!");
                    Study();
                    break;
                case "b":
                    System.out.println("Great! Whats the answer?");
                    String guess = in.nextLine();
                    if (guess.equals(ans)) {
                        System.out.println("Great that's correct! :)");
                        moveForward(f, b);
                    } else {
                        System.out.println("Sorry, that's incorrect :(");
                        moveBack(f, b);
                    }
                    Study();
                    break;
                case "c":
                    System.out.println("The answer is: " + ans);
                    System.out.println("\nStudy this one a bit more!");
                    moveBack(f, b);
                    Study();
                    break;
                case "d":
                    System.out.println("You have chosen to end the Study session.");
                    startSwitch = false;
                    break;

            }
        }

    }
    public void moveForward(FlashCard f, Box b){
        if(b.getBoxNum() == 1 ){
            b.deleteFlashcard(f);
            box2.addFlashcard(f);
        }
        else if(b.getBoxNum() == 2){
            b.deleteFlashcard(f);
            box3.addFlashcard(f);
        }
        else if(b.getBoxNum() == 3){
            b.deleteFlashcard(f);
            box4.addFlashcard(f);
        }
        else if(b.getBoxNum() == 4){
            b.deleteFlashcard(f);
            box5.addFlashcard(f);
        }
        else{

        }
    }
    public void moveBack(FlashCard f, Box b){
        if(b.getBoxNum() == 2 ){
            b.deleteFlashcard(f);
            box1.addFlashcard(f);
        }
        else if(b.getBoxNum() == 3){
            b.deleteFlashcard(f);
            box2.addFlashcard(f);
        }
        else if(b.getBoxNum() == 4){
            b.deleteFlashcard(f);
            box3.addFlashcard(f);
        }
        else if(b.getBoxNum() == 5){
            b.deleteFlashcard(f);
            box4.addFlashcard(f);
        }
        else{

        }

    }
}