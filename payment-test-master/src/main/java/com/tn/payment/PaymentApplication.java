package com.tn.payment;

import com.tn.payment.common.Context;
import com.tn.payment.common.Initialize;
import com.tn.payment.entity.PaymentRecord;
import com.tn.payment.utils.CommonUtil;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

//@SpringBootApplication
public class PaymentApplication {

    public static void main(String[] args) {
        //SpringApplication.run(PaymentApplication.class, args)
        System.out.println("sytem is initializing...");
        Initialize ina = new Initialize();
        ina.initializeCurrencyAndExchangeRate();

        System.out.println("intput \"quit\" to exit.");

        System.out.println("input the  fileName which will be inported...");


        List<String> result = null;
        //等用户输入文件名
        Context context = new Context();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();
            if (message.equals("skip")) {

                break;
            }
            if (message.equals("quit")) {
                System.exit(0);
            }

            try {
                result = CommonUtil.readFile(message, Context.CURRENCY_CODE_REGEX);
                break;
            } catch (FileNotFoundException e) {
                System.out.println("File not found,is skip?input skip");
            } catch (IOException e) {
                System.out.println("IOException error");
            }
        }

        if (result != null) {
            for (String str : result) {
                context.put(str.split(" ")[0], str.split(" ")[1]);
            }
        }
        //线程运行用户输入currency amount
        ThreadRun myThread = new ThreadRun();
        Thread thread = new Thread(myThread);
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.start();
        //打印线程
        PrintThreadRun printThreadRun = new PrintThreadRun();
        Thread pthread = new Thread(printThreadRun);
        try {
            pthread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pthread.start();

    }

}
