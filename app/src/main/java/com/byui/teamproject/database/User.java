package com.byui.teamproject.database;

import java.util.Random;

public class User {

    private static int count = 12585;

    public String id = "";
    public String name = "";
    public String email = "";
    public String password = "";
    public String position = "";
    public String lastLoggedIn = "";
    public String lastLoggedOut = "";

    public User(String name, String email, String password, String position) {
        this.id = Integer.toString(count);
        this.name = name;
        this.email = email;
        this.password = password;
        this.position = position;
        this.lastLoggedIn = "2021/12/" + randomNumber(0, 13) + "  " + randomNumber(0, 24) + ":" + randomNumber(0, 60) + ":" + randomNumber(0, 60);
        this.lastLoggedOut = "2021/12/" + randomNumber(0, 13) + "  " + randomNumber(0, 24) + ":" + randomNumber(0, 60) + ":" + randomNumber(0, 60);

        count += 5;
    }

    @Override
    public String toString() {
        return this.name + "\nID: " + this.id + "\nLast login: " + this.lastLoggedIn + "\nLast logout: " + this.lastLoggedOut;
    }

    private static int randomNumber(int min, int max) {
        Random random = new Random();
        int x = random.nextInt((max - min) + 1) + min;
        return x;
    }
}
