import java.util.ArrayList;
import java.util.List;

public class Box {
    private int boxNum;

    private List<FlashCard> flashcards; // store flashcards in a list

    public Box(int i) {
        assert i > 0;
        this.boxNum = i;
        flashcards = new ArrayList<FlashCard>();

    }
    /**
     * Adds a Flashcard to box.
     * */
    public void addFlashcard(FlashCard b1) {
        flashcards.add(b1);

    }

    /**
     * Returns the number of box flashcard is in
     * */
    public int id(){
        return this.boxNum;
    }

    /**
     * Returns the amount of cards in a box.
     * */
    public int size(){
            return flashcards.size();
    }

    /**
     * Deletes a flashcard from a box.
     * */
    public void deleteFlashcard(FlashCard b5) {
        flashcards.remove(b5);
    }

    /**
     * Returns a copy of all flashcards.
     * */
    public List<FlashCard> getFlashcards() {
        ArrayList<FlashCard> copy = new ArrayList<FlashCard>();

        for(FlashCard x: flashcards){
            copy.add(x);
        }
        return copy;
    }

    /**
     * Returns flashcard at index.
     * */
    public FlashCard get(int idx) {
        return flashcards.get(idx);
    }


}


