package com.crawler;

import com.page.Type;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 发送请求
 * 获取响应
 * 解析响应
 * 过滤数据
 * 处理数据
 */
public class Crawler {

    /**
     * https://m.zwdu.com/book/23488/
     */

    /**
     * 发送请求
     * 接受响应
     * @return
     */
    public void sendAndGet(String urlStr){

        HttpURLConnection connection =  null;
        String result = null;
        List<String> urls = new ArrayList<>();

        //字符流
        BufferedReader br = null;

        //打印输出流
        PrintWriter pw = null;

        //网站url匹配规则
        String regex = "https://m.zwdu.com/book/[1-9][0-9]*[.html]";
        //String regex = "https://";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(urlStr);

        if (matcher.find() == false){
            return;
        }

        System.out.println(matcher.group());

        URL url = null;

        try {
            //连接URL
            url = new URL(urlStr);
            connection = (HttpURLConnection)url.openConnection();

            //发送请求
            connection.connect();

            //获取响应码
            if (connection.getResponseCode() == 200){

                File file = new File("F:\\OtherFiles\\crawler.txt");

                if (file == null){
                    file.createNewFile();
                }

                //打印输出
                pw = new PrintWriter(new FileWriter(file),true);

                //字节流转字符流
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String buffer = null;

                if (br != null){
                    while ((buffer = br.readLine()) != null){

                        matcher = pattern.matcher(buffer);
                        if (matcher.find()){
                            String data = matcher.group();
                            System.out.println(data);
                            urls.add(data);
                            pw.println(data);
                        }

                    }
                }
                for (String str:urls) {
                    sendAndGet(str);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

