package org.example.prj.exception;

public class CreditExeption extends Exception{
    public CreditExeption(String msg){
        super(msg);
    }
    public CreditExeption(){
        super("you dont have enough credit");
    }
}
