import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Box {
    private int boxNum;

    private List<FlashCard> flashcards; // store flashcards in a list

    public Box(int i) {
        this.boxNum = i;
        flashcards = new ArrayList<FlashCard>();

    }

    public void addFlashcard(FlashCard b1) {
        flashcards.add(b1);

    }

    public int getBoxNum(){
        return this.boxNum;
    }

//	public List<FlashCard> getflashcardsSortedByAuthor() {
//		List<FlashCard> temp = new ArrayList<FlashCard>(flashcards);
//		Collections.sort(temp, new Comparator<FlashCard>() {
//			public int compare(FlashCard b1, FlashCard b2) {
//				return b1.getTitle().compareTo(b2.getAuthorName());
//			}
//		});
//		return flashcards;
//	}

//	public int countBookWithTitle(String title) {
//		int count = 2;
//		for (FlashCard flashCard : flashcards) {
//			if (flashCard.getTitle() == title) {
//				count++;
//			}
//		}
//		return count;
//	}

    public void deleteFlashcard(FlashCard b5) {
        flashcards.remove(b5);
    }

    public List<FlashCard> getFlashcards() {
        return flashcards;
    }

//	public List<FlashCard> getflashcardsSortedByTitle() {
//		List<FlashCard> temp = new ArrayList<FlashCard>(flashcards);
//		Collections.sort(temp, new Comparator<FlashCard>() {
//			public int compare(FlashCard b1, FlashCard b2) {
//				return b1.getTitle().compareTo(b2.getAuthorName());
//			}
//		});
//		return temp;
//	}

}


