package org.example.task5.dto;

public class UserProducts {
    private long userId;
    private long productId;

    public UserProducts() {
    }

    public UserProducts(long userId, long productId) {
        super();
        this.userId = userId;
        this.productId = productId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
