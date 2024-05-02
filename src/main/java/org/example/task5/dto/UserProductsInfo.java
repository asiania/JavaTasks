package org.example.task5.dto;


public class UserProductsInfo {
    private long userId;
    private String userName;
    private long productId;
    private int productAccNum;
    private double balance;
    private String type;

    public UserProductsInfo() {
    }

    public UserProductsInfo(long userId, String userName, long productId, int productAccNum, double balance, String type) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.productId = productId;
        this.productAccNum = productAccNum;
        this.balance = balance;
        this.type = type;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getProductAccNum() {
        return productAccNum;
    }

    public void setProductAccNum(int productAccNum) {
        this.productAccNum = productAccNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
