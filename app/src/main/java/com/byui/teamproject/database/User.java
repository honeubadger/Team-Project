package com.byui.teamproject.database;

public class User {

    private static int count = 12585;

    public String id = "";
    public String name = "";
    public String email = "";
    public String password = "";
    public String position = "";

    public User(String name, String email, String password, String position) {
        this.id = Integer.toString(count);
        this.name = name;
        this.email = email;
        this.password = password;
        this.position = position;

        count += 5;
    }
}
