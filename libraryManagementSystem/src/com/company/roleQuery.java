package com.company;

import java.util.Scanner;

public class roleQuery {

    static Scanner scn = new Scanner(System.in);
    lists lists = new lists();

    public static void queryRole(lists lists){
        System.out.println("Hangi rolde olmak istersiniz?");
        System.out.println("-- Yonetici -- Kullanici");
        String role = scn.nextLine();

        switch(role){
            case "Yonetici":
                lists.setUser(false);
                lists.setManager(true);
                if(lists.isManager()){
                    System.out.println("Yonetici rolu verildi.");
                }
                break;
            case "Kullanıcı":
                lists.setManager(false);
                lists.setUser(true);
                if(lists.isUser()){
                    System.out.println("Kullanici rolu verildi.");
                }
                break;
            default:
                System.out.println("Hatalı komut girdiniz!");
                break;
        }
    }
}
