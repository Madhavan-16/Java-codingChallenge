package com.Exception;

@SuppressWarnings("serial")
public class PolicyNotFoundException extends Exception {

    public PolicyNotFoundException() {
        System.out.println("Policy not found in the database.");
    }

    public PolicyNotFoundException(String message) {
        super(message);
    }
}


