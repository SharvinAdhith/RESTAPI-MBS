package com.example.mbs.model;

public class PaymentResponse {
    private String transactionId;
    private String status;
    private double amount;
    private String message;

    public PaymentResponse() {}

    public PaymentResponse(String transactionId, String status, double amount, String message) {
        this.transactionId = transactionId;
        this.status = status;
        this.amount = amount;
        this.message = message;
    }

    public String getTransactionId(){
        return transactionId;
    }

    public void setTransactionId(String transactionId){
        this.transactionId = transactionId;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public double getAmount(){
        return amount;
    }

    public void setAmount(double amount){
        this.amount = amount;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
