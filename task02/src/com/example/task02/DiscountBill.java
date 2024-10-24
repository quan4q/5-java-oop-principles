package com.example.task02;

public class DiscountBill extends Bill{
    private final int discount;

    public DiscountBill(int discount){
        this.discount = discount;
    }

    public int getDiscount(){
        return discount;
    }

    public long getAbsolutePrice(){
        return super.getPrice() - getPrice();
    }

    @Override
    public long getPrice(){
        return (long) (super.getPrice() - (super.getPrice() * (discount / 100)));
    }
}
