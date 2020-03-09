package com.tn.payment.entity;

public class CurrencyRate {
    private String currency;
    private float exchangeRate;

    /**
     * 币种
     */
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * 转美元比例
     */
    public float getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(float exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
