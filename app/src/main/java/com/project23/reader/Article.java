package com.project23.reader;

import java.util.ArrayList;

/**
 * Created by TomSingleton on 02/01/15.
 */
public class Article {

    private String title;
    private String body;
    private ArrayList<String> tags;
    private Long priority;

    public Article() {
        tags = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }
}
