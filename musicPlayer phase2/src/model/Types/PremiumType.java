package model.Types;

public enum PremiumType {
    THIRTY(5 , 30), SIXTY(9 , 60) , ONEHUNDREDEIGHTY(14 , 180);
    public int price , value;

    PremiumType(int price , int value) {
        this.price = price;
        this.value = value;
    }
}
