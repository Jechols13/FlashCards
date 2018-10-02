public class FlashCard {

    private int id; // the unique id assigned to book
    private String front; // book title
    private String back;// author of the book

    public FlashCard() {
        super();
    }

    public FlashCard( String front, String back) {

        this.front = front;
        this.back = back;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

//	public String getAuthorName() {
//		return authorName;
//	}
//
//	public void setAuthorName(String authorName) {
//		this.authorName = authorName;
//	}

    @Override
    public String toString() {
        return "\n FlashCard [ Front= " + front + ", Back= "
                + back + "]";
    }

}
