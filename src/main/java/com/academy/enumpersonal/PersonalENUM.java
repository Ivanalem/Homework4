package com.academy.enumpersonal;

public class PersonalENUM {

    private String first_name;

    private PersonalENUM(String first_name) {
        this.first_name = first_name;
    }

    public static PersonalENUM Elena = new PersonalENUM("Elena");
    public static PersonalENUM Katya = new PersonalENUM("Katya");
    public static PersonalENUM Milana = new PersonalENUM("Milana");
}

