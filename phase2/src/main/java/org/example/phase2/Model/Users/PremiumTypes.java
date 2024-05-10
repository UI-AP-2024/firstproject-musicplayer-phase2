package org.example.phase2.Model.Users;

public enum PremiumTypes {
    ONEMONTH(5),TWOMONTHS(9),SIXMONTHS(14);
    final int price;

    private PremiumTypes(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
