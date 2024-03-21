package controllers;

import services.DiaryServiceImplement;

public class DiaryController {
    public void login(String userName, String password){
        DiaryServiceImplement diaryServiceImplement = new DiaryServiceImplement();
        diaryServiceImplement.logIn(userName, password);
    }

}
