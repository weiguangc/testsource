package com.tn.payment;

import com.tn.payment.common.Context;
import com.tn.payment.entity.PaymentRecord;
import com.tn.payment.utils.CommonUtil;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 用户输入
 */
public class ThreadRun implements   Runnable {

    @Override
    public void run() {
        Context context=new Context();

        //用户输入
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();
            if(message.equals("quit"))
            {
                System.exit(0);
            }
            if (Pattern.matches(Context.CURRENCY_CODE_REGEX, message))
           {
                context.put(message.split(" ")[0],message.split(" ")[1]);
            } else {
                System.out.println("Invalid data format. Please input the data  like 'USD 100'");
            }
        }

    }
}
