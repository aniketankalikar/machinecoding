package com.example.bookmyshow.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long custId) {
        super("Customer with Id "+custId+" Not found");
    }
}
