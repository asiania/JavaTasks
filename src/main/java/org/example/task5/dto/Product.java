package org.example.task5.dto;

public class Product {

    private long id;
    private int accnum;
    private double balance;
    private String type;

    public Product() {
    }

    public Product(long id, int accnum, double balance, String type) {
        super();
        this.id = id;
        this.accnum = accnum;
        this.balance = balance;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public int getAccnum() {
        return accnum;
    }

    public double getBalance() {
        return balance;
    }

    public String getType() {
        return type;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAccnum(int accnum) {
        this.accnum = accnum;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setType(String type) {
        this.type = type;
    }
}
