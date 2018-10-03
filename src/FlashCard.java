public class FlashCard {

    private String front; // Front of flashcard
    private String back;// Back of flashcard

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


    @Override
    public String toString() {
        int i = (int) (Math.random()*10);
        if( i < 5){
            return  front + "";
        }
        else {
            return back + "";
        }
    }

}
