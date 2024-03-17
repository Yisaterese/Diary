package model;

public class Entry {
    private String body;
    private String title;
    private String author;
    private int Id;
    public Entry(){

    }
    public Entry(String author, String body, String title ){
        this.body = body;
        this.title = title;
        this.author = author;
    }
    public void update(Entry body) {

    }
}
