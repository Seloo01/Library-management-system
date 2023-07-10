package panels;

import com.company.lists;

public class removeBookPanel {

    lists lists = new lists();

    int bookId;
    String bookName;

    public removeBookPanel(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;

        boolean controlKey = lists.books.containsKey(bookId);

        if(controlKey){
            lists.books.remove(bookId);
            System.out.println(bookName + " adında " + bookId + " ürün koduna sahip kitap başarılı bir şekilde silindi!");
        }else{
            System.out.println("Böyle bir kitap bulunamadı!");
        }
    }
}
