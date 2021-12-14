package com.byui.teamproject.database;

import java.util.ArrayList;
import java.util.Arrays;

public class MyDatabase {

    public static User currentUser;

    public static ArrayList<User> users = new ArrayList<User>(Arrays.asList(
            new User("Edward", "edward@email.com", "abc123456", "Software Developer", true),
            new User("Lleir", "lleir@email.com", "abc123456", "Manager", true),
            new User("Alex", "alex@email.com", "abc123456", "Team Leader", true),
            new User("Nana", "nana@email.com", "abc123456", "Data Scientist", true)
    ));

}
