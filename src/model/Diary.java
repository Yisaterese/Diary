package model;
public class Diary {
    private String userName;
    private String password;
    private boolean isLocked;
    public String getUserName(){
        return userName;
    }
    public String getPassword(){return this.password;}
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {this.password = password;}
    public void setLock(boolean trueOrFalse) {
        isLocked = trueOrFalse;
    }
    public boolean isLocked(){ return isLocked;}

    public boolean isUnlocked() {
        return isLocked = true;
    }

    public Entry getEntry() {
    }
}

