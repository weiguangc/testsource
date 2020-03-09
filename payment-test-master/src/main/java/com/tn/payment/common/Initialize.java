package com.tn.payment.common;

import com.tn.payment.entity.CurrencyRate;
import com.tn.payment.entity.PaymentRecord;
import com.tn.payment.utils.CommonUtil;
import java.util.List;
import java.util.Properties;

/**
 * initial system
 */
public class Initialize {
   public void initializeCurrencyAndExchangeRate()
   {
       //read config file ,get exchange rate which has known
       Properties properties =CommonUtil.readPropertiesFile("application.properties");
       String curRate= (String) properties.get("currencyAndExchangeRate");
       List<CurrencyRate> curlist=(List<CurrencyRate>)CommonUtil.jsonToList(curRate);
       for (CurrencyRate crItem:curlist
            ) {
           PaymentRecord pItem=new PaymentRecord();
           pItem.setCurrency(crItem.getCurrency());
           pItem.setExchangeRate(crItem.getExchangeRate());
           Context.paymentRecordMap.put(crItem.getCurrency(),pItem);
       }
   }

}
