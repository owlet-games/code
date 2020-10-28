package com;

import com.crawler.Crawler;

public class CrawlerMain {

    public static void main(String[] args) {
        Crawler crawler = new Crawler();

        String urlStr = "https://m.zwdu.com/book/";

        crawler.sendAndGet(urlStr);
    }
}
