package listOperations;


import com.company.lists;

import java.util.Map;

public class listAllBooks {

    lists lists = new lists();

    int bookId;
    String bookName;
    int bookAmount;

    public listAllBooks(int bookId, String bookName, int bookAmount) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAmount = bookAmount;

        int count = 1;
        for (Map.Entry<Integer, String> entry : lists.books.entrySet()) {
            printWithCount(count, entry.getValue(),entry.getKey());
            count++;
        }
    }

    public void printWithCount(int count, String value, int id) {
        if(!lists.books.isEmpty()){
            System.out.println(count + ". " + value + " || kitap kodu: " + id);
        }else{
            System.out.println("Listelenebilecek bir kitap yok. Kitaplık henüz boş!");
        }
    }
}
