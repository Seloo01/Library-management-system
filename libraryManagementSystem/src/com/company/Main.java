package com.company;

import listOperations.listAllBooks;
import panels.addBookPanel;
import panels.removeBookPanel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static boolean isActivated = true;

    public static void main(String[] args) {

        int bookid = 0;
        String bookname = "";
        int bookamount = 0;

        Scanner scn = new Scanner(System.in);
        lists lists = new lists();
        roleQuery roleQuery = new roleQuery();

        addBookPanel addBook;
        removeBookPanel removeBook;
        listAllBooks listAllBooks;

        roleQuery.queryRole(lists);
        if (isHaveRole(lists)) {
            while (isActivated) {
                welcomeMessage();
                String selectOperation = scn.nextLine();
                switch (selectOperation) {
                    case "ekle":
                        if (lists.isManager()) {
                            try {
                                System.out.println("Lütfen eklemek istediğiniz kitabın kodunu giriniz: ");
                                bookid = scn.nextInt();
                                scn.nextLine();

                                System.out.println("Lütfen eklemek istediğiniz kitabın ismini giriniz: ");
                                bookname = scn.nextLine();

                                System.out.println("Lütfen " + bookname + " adlı kitabınızn kaç adet olacağını giriniz: ");
                                bookamount = scn.nextInt();
                                scn.nextLine();

                                addBook = new addBookPanel(bookid, bookname, bookamount);

                            } catch (InputMismatchException e) {
                                System.out.println("Hatalı giriş yaptınız. Lütfen doğru veri tipinde giriş yapın.");
                                scn.nextLine();
                                continue;
                            }
                        } else {
                            System.out.println("Bunu yapabilmeniz için yönetici olmak zorundasınız!");
                        }
                        break;
                    case "sil":
                        if (lists.isManager()) {
                            try {
                                System.out.println("Lütfen silmek istediğiniz kitabın ürün kodunu giriniz: ");
                                bookid = scn.nextInt();
                                scn.nextLine();

                                System.out.println("Lütfen silmek istediğiniz kitabın ismini giriniz: ");
                                bookname = scn.nextLine();

                                removeBook = new removeBookPanel(bookid, bookname);

                            } catch (InputMismatchException e) {
                                System.out.println("Hatalı giriş yaptınız. Lütfen doğru veri tipinde giriş yapın.");
                                scn.nextLine();
                                continue;
                            }
                        } else {
                            System.out.println("Bunu yapabilmeniz için yönetici olmak zorundasınız!");
                        }
                        break;
                    case "listele":
                        if (lists.isManager() || lists.isUser()) {
                            listAllBooks = new listAllBooks(bookid, bookname, bookamount);
                        }
                        break;
                    case "rol değiş":
                        roleQuery.queryRole(lists);
                        break;
                    case "hepsini sil":
                        if(lists.isManager()){
                            if(lists.books.size() > 1 && lists.bookAmountFromBookName.size() > 1) {
                                lists.books.clear();
                                lists.bookAmountFromBookName.clear();
                                System.out.println("Bütün kitaplar başarılı bir şekilde silindi!");
                            }
                        }else {
                            System.out.println("Bunu yapabilmeniz için yönetici olmak zorundasınız!");
                        }
                        break;
                    default:
                        System.out.println("Hatalı işlem girişi yaptınız. Lütfen tekrar deneyiniz.");
                        break;
                }
            }
        }
    }

    public static void welcomeMessage() {
        System.out.println("Hoşgeldiniz. Ne yapmak istersiniz?");
        System.out.println("  - ekle *--* sil *--* listele -");
    }

    public static boolean isHaveRole(lists lists) {
        while (true) {
            if (lists.isManager() || lists.isUser()) {
                return true;
            } else {
                roleQuery.queryRole(lists);
            }
        }
    }
}
