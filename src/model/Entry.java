package model;

public class Entry {
    private String body;
    private String title;
    private String author;
    private int id;
    public Entry(){

    }
    public Entry(String author, String body, String title ){
        this.body = body;
        this.title = title;
        this.author = author;
    }
    public void setId(int id) {
           this.id = id;
    }

    public String getTitle() {
        return title;
    }
}
