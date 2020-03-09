package com.tn.payment;

import com.tn.payment.common.Context;
import com.tn.payment.common.Initialize;
import org.junit.Test;

public class PaymentApplicationTest {
    @Test
    public void main() {
        System.out.println("sytem is initializing...");
        Initialize ina = new Initialize();
        ina.initializeCurrencyAndExchangeRate();
        Context context = new Context();
        for (int j = 1; j < 100; j++) {

            context.put(String.valueOf(j), String.valueOf(j * 10));
        }
        for (int j = 1; j < 100; j++) {
            PrintThreadRun printThreadRun = new PrintThreadRun();

            Thread pthread = new Thread(printThreadRun);

            pthread.start();
        }

    }

}