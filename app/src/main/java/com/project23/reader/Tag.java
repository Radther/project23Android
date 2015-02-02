package com.project23.reader;

/**
 * Created by TomSingleton on 02/01/15.
 */
public class Tag {

    private String tagName;
    private long tagPriority;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public long getTagPriority() {
        return tagPriority;
    }

    public void setTagPriority(long tagPriority) {
        this.tagPriority = tagPriority;
    }

    @Override
    public String toString() {
        return "TagName: "+tagName +" Priority: "+String.valueOf(tagPriority);
    }
}
