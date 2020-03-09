package com.tn.payment;

import com.tn.payment.common.Context;
import com.tn.payment.entity.PaymentRecord;
import com.tn.payment.utils.CommonUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 打印
 */
public class PrintThreadRun implements Runnable {

    @Override
    public void run() {
        Context context = new Context();
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);

        while (true) {
            try {
                System.out.println(sdf.format(new Date()) + " payments is:");
                context.print();
                TimeUnit.SECONDS.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
