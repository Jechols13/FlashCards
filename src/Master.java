import java.util.Scanner;

public class Master {

    Box box1 = new Box();
    Box box2 = new Box();
    Box box3 = new Box();
    Box box4 = new Box();
    Box box5 = new Box();


    String input = "";
    String front = "";
    String back = "";


    public void CreateFlashCard(){

        Scanner in = new Scanner(System.in);

        System.out.println("Please enter in the front of the card:");
        front = in.nextLine();
        System.out.println("Please enter in the back of the card:");
        back = in.nextLine();
        FlashCard x = new FlashCard(front, back);
        box1.addFlashcard(x);
    }

    public void Study(){

    }
}