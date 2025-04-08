package com.academy.enum_personal;

public class Personal_ENUM{

    private String first_name;

    private Personal_ENUM(String first_name){
        this.first_name = first_name;
    }

    public static Personal_ENUM Elena = new Personal_ENUM("Elena");
    public static Personal_ENUM Katya = new Personal_ENUM("Katya");
    public static Personal_ENUM Milana = new Personal_ENUM("Milana");
    }

