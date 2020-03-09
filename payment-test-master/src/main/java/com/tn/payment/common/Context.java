package com.tn.payment.common;

import com.tn.payment.entity.PaymentRecord;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * 全局上下文
 */
public class Context {
    /**
     * 作全局使用
     */
    static public Map<String, PaymentRecord> paymentRecordMap = new HashMap<String, PaymentRecord>();

    public final static String CURRENCY_CODE_REGEX = "^[A-Z]{3} [-]?\\d+(\\.\\d+)?$";

    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    /**
     * @param key
     * @param amountValue
     */
    public void put(String key, String amountValue) {
        rwLock.writeLock().lock();
        try {
            PaymentRecord pItem = Context.paymentRecordMap.get(key);
            //already have
            if (null != pItem) {
                pItem.setAmount(pItem.getAmount() + Float.parseFloat(amountValue));
                if (pItem.getExchangeRate() != 0.0f) {
                    pItem.setUsdAmount(pItem.getAmount() / pItem.getExchangeRate());
                }
            } else  //new currency
            {
                PaymentRecord newPay = new PaymentRecord();
                newPay.setAmount(Float.parseFloat(amountValue));
                pItem = Context.paymentRecordMap.put(key, newPay);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    /**
     * 读操作
     */
    public void print() {
        rwLock.readLock().lock();
        try {
            for (Map.Entry<String, PaymentRecord> entry : paymentRecordMap.entrySet()) {

                String outString="";

                if (entry.getValue().getAmount() != 0f) {
                    outString=(entry.getKey() + " " + entry.getValue().getAmount());
                }
                if(entry.getValue().getUsdAmount()>0f&&(!entry.getValue().getCurrency().equals("USD")))
                {
                    outString+="  (USD " + entry.getValue().getUsdAmount()+")";
                }
                if (entry.getValue().getAmount() != 0f)
                {
                    System.out.println(outString);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }
    }

}
