package com.company;

public class MyException extends Exception{

    public final String randomUUID;

    public MyException(String randomUUID) {

        this.randomUUID = randomUUID;
    }

    public String getRandomUUID() {
        return randomUUID;
    }
}