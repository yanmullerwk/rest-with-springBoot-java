package com.yanproject.rest_with_spring_e_java;


public class HelloWorld {
    private final long ID;
    private final String content;

    public HelloWorld(long ID, String content) {
        this.ID = ID;
        this.content = content;
    }
    public long getID() {
        return ID;
    }
    public String getContent() {
        return content;
    }

    
}
