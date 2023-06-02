import java.util.*;

class Borrowing{
    private String id;
    private String bookID;
    private String clientID;
    private Date dateBorrowed;
    private Date dateGiveBack;
    private int price;
    private String status;

    Borrowing(String id, String bookID, String clientID,
            Date dateBorrowed, Date dateGiveBack, int price, String status){
        this.id = id;
        this.bookID = bookID;
        this.clientID = clientID;
        this.dateBorrowed = dateBorrowed;
        this.dateGiveBack = dateGiveBack;
        this.price = price;
        this.status = status;
    }

    public String getID() {
        return this.id;
    }

    public String getBookID() {
        return this.bookID;
    }

    public String getClient() {
        return this.clientID;
    }

    public Date getBorrowedDate() {
        return this.dateBorrowed;
    }

    public Date getReturnDate() {
        return this.dateGiveBack;
    }

    public int getPrice() {
        return this.price;
    }

    public String getStatus() {
        return this.status;
    }

    public void create(){

    }

    public void update(){

    }

    public void cancel(){

    }
}