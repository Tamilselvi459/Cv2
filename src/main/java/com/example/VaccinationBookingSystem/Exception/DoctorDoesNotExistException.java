package com.example.VaccinationBookingSystem.Exception;

public class DoctorDoesNotExistException extends RuntimeException{
    public DoctorDoesNotExistException(String message){
        super(message);
    }
}
