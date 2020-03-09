package com.tn.payment.utils;

import com.tn.payment.common.Context;
import org.junit.Test;
import java.io.IOException;

public  class CommonUtilTest {
    @Test
    public void readPropertiesFile() {
        com.tn.payment.utils.CommonUtil.readPropertiesFile("application.properties");
    }

    @Test
   public void readFile() {
        try {
            CommonUtil.readFile("data.txt", Context.CURRENCY_CODE_REGEX);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}