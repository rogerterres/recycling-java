package com.javamasterclass;

public class Main {

    public static void main(String[] args) {
        ITelephone rogersPhone;
        rogersPhone = new DeskPhone(123456789);
        rogersPhone.powerOn();
        rogersPhone.callPhone(123456789);
        rogersPhone.answer();

        rogersPhone = new MobilePhone(987654321);
        rogersPhone.powerOn();
        rogersPhone.callPhone(987654321);
        rogersPhone.answer();
    }
}
