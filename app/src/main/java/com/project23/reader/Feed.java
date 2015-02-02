package com.project23.reader;

import java.util.ArrayList;

/**
 * Created by TomSingleton on 12/01/15.
 */
public class Feed {

    private ArrayList<Article> articleArrayList = new ArrayList<>();

    private static Feed ourInstance = new Feed();

    public static Feed getInstance() {
        return ourInstance;
    }

    private Feed() {
    }

    public ArrayList<Article> getArticleArrayList() {
        return articleArrayList;
    }

    public void setArticleArrayList(ArrayList<Article> articleArrayList) {
        this.articleArrayList = articleArrayList;
    }
}
