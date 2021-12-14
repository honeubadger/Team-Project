package com.byui.teamproject.database;

import java.util.ArrayList;
import java.util.Arrays;

public class MyDatabase {

    public static User currentUser;

    public static ArrayList<User> users = new ArrayList<User>(Arrays.asList(
            new User("Edward", "edward@email.com", "abc123456", "Software Developer"),
            new User("Lleir", "lleir@email.com", "abc123456", "Manager"),
            new User("Alex", "alex@email.com", "abc123456", "Team Leader"),
            new User("Nana", "nana@email.com", "abc123456", "Data Scientist")
    ));

}
