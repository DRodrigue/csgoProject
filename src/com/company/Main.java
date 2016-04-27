package com.company;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<String> allTeamLinks = new ArrayList<>();

        String url = ("http://www.gosugamers.net/counterstrike/teams/");
        Document doc = getDoc(url);
        Elements teamList = doc.select("div.header.clearfix h3");
        Elements nextPage = doc.select("div.pages");

        // Supposed to get all the next pages that their are to then be put in a list array
        for(Element page : nextPage) {

            String nextPages = page.select("a").attr("href").replaceFirst("/counterstrike/teams", "");
            System.out.println(url+nextPages);
        }

              // This gets the all team lists url and add them to a array list
        for(Element teams : teamList ) {
            String teamLinks = teams.select("a").attr("href").replaceFirst("/counterstrike/teams/", "");
            allTeamLinks.add(url + teamLinks);

        }

        System.out.println(allTeamLinks);

    }

    private static Document getDoc(String url){
        Document doc = null;
        try {
            doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.81 Safari/537.36")
                    .timeout(60000)
                    .get();
        } catch (IOException e)  {
            e.printStackTrace();
        }

        return doc;
    }
}
