package panels;

import com.company.lists;

import java.util.Map;
import java.util.Scanner;

public class addBookPanel {

    lists lists = new lists();
    Scanner scn = new Scanner(System.in);

    int bookId;
    String bookName;
    int bookAmount;

    public addBookPanel(int bookId, String bookName, int bookAmount){
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAmount = bookAmount;

        boolean controlKey = lists.books.containsKey(bookId);

        if(!controlKey){
            lists.books.put(bookId,bookName);
            lists.bookAmountFromBookName.put(bookId,bookAmount);
            System.out.println(lists.books.get(bookId) + " adlı kitap " + lists.bookAmountFromBookName.get(bookId) + " " +
                    "adet olucak şekilde başarılı bir şekilde eklenmiştir!");
        }
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookAmount() {
        return bookAmount;
    }

    public void setBookAmount(int bookAmount) {
        this.bookAmount = bookAmount;
    }
}
