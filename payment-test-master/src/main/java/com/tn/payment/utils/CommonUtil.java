package com.tn.payment.utils;


import com.tn.payment.entity.CurrencyRate;
import net.sf.json.JSONArray;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

public class CommonUtil {

    /**
     * 通过配置文件名读取内容
     *
     * @param fileName
     * @return
     */
    public static Properties readPropertiesFile(String fileName) {
        try {
            Resource resource = new ClassPathResource(fileName);
            Properties props = PropertiesLoaderUtils.loadProperties(resource);
            return props;
        } catch (Exception e) {
            System.out.println("————读取配置文件：" + fileName + "出现异常，读取失败————");
            e.printStackTrace();
        }
        return  null;
    }

    public static List<CurrencyRate> jsonToList(String jsonString) {

        System.out.println(jsonString);
        JSONArray json = JSONArray.fromObject(jsonString);
        System.out.println(json);
        List<CurrencyRate> ts = (List<CurrencyRate>) JSONArray.toCollection(json, CurrencyRate.class);//.parseArray(, PaymentRecord.get);
        return ts;

    }

    /**
     * 导入数据
     *
     * @param path
     * @return
     * @throws IOException
     */
    public static List<String> readFile(String path, String pattern) throws IOException {
        System.out.println(System.getProperty("user.dir"));

        List<String> result = new ArrayList<String>();
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        try {

            fileInputStream = new FileInputStream(path);
            inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                if (Pattern.matches(pattern, line)) {
                    result.add(line);
                }
            }
        }  finally {
            if(bufferedReader!=null) {
                bufferedReader.close();
            }
            if(inputStreamReader!=null) {
                inputStreamReader.close();
            }
            if(fileInputStream!=null) {
                fileInputStream.close();
            }
        }

        return result;
    }
}
