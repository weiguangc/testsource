package com.tn.payment.entity;

/**
 * 付款实体类
 */
public class PaymentRecord {
    private String currency;
    private float amount;
    private float exchangeRate;
    private float usdAmount;

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
     *金额
     */
    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
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

    /**
     * 美元金额
     */
    public float getUsdAmount() {
        return usdAmount;
    }

    public void setUsdAmount(float usdAmount) {
        this.usdAmount = usdAmount;
    }
}
