package com.minigame;

import com.minigame.utils.Constants;

public class Box {
    private int amount = 0;
    private Constants.SpecialSign special_sign;

    public Box (int amount){
        this.amount = amount;
    }

    public Box(Constants.SpecialSign special_sign){
        this.special_sign = special_sign;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Constants.SpecialSign getSpecial_sign() {
        return special_sign;
    }

    public void setSpecial_sign(Constants.SpecialSign special_sign) {
        this.special_sign = special_sign;
    }

    @Override
    public String toString(){
        return " amount: " + this.getAmount() + ", sign: " + this.getSpecial_sign();
    }
}
