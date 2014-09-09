package com.matthewdyer.assignment1.net;

public class MediaWeb {

    private final long id;
    private final String content;

    public MediaWeb(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
    
    public String getStaticContent(){
    	return " {content:\"I am also JSON!\"}";
    }
}
