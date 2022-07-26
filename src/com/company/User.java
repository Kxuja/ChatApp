package com.company;

import java.util.ArrayList;

public class User {
    ArrayList<UserChats> myChats = new ArrayList<UserChats>();
    int myBalance;
    String email;
    String  password;
    String name;
    ArrayList<UserChats> userChats =new ArrayList<UserChats>();
    public User() {
    }

    public User(ArrayList<UserChats> myChats, int myBalance, String email, String password, String name, ArrayList<UserChats> userChats) {
        this.myChats = myChats;
        this.myBalance = myBalance;
        this.email = email;
        this.password = password;
        this.name = name;
        this.userChats = userChats;
    }
}
