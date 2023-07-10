package com.company;

import java.util.HashMap;

public class lists {

    public static HashMap<Integer, String> books = new HashMap<>();
    public static HashMap<Integer, Integer> bookAmountFromBookName = new HashMap<>();

    boolean manager;
    boolean user;

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public boolean isUser() {
        return user;
    }

    public void setUser(boolean user) {
        this.user = user;
    }
}
