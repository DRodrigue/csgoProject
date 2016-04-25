package com.company;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here


        String url = ("http://www.gosugamers.net/counterstrike/teams/");
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.81 Safari/537.36")
                .timeout(60000)
                .get();

        Elements teamList = doc.select("div.header.clearfix h3");
        Elements nextPage = doc.select("div.pages");

        for(Element page : nextPage) {
            String nextPages = page.select("a").attr("href").replaceFirst("/counterstrike/teams","");

            System.out.println(nextPages);
        }
              // This gets the team lists url
        for(Element teams : teamList ) {
           String teamLinks = teams.select("a").attr("href").replaceFirst("/counterstrike/teams/","");

            //System.out.println(url + teamLinks);
        }

    }
}
