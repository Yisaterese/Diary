package model;

public class Diary {
    private String userName;
    private String password;
    public Diary(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public  Diary(){
    }

    public String getUserName(){return this.userName;}
    public void delete(String  userName) {

    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {this.password = password;}
}

