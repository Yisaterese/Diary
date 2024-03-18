package model;

public class Diary {
    private String userName;
    private String password;

    public  Diary(){
    }

    public String getUserName(){return userName;}
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {this.password = password;}
}

