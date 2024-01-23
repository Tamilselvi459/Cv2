package com.example.VaccinationBookingSystem.Exception;

public class EmailDoesNotExists extends RuntimeException{
    public EmailDoesNotExists (String message){
        super(message);
    }
}
