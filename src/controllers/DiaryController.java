package controllers;

import dto.request.LogInRequest;
import services.DiaryServiceImplement;

public class DiaryController {
    public void login(LogInRequest logInRequest){
        DiaryServiceImplement diaryServiceImplement = new DiaryServiceImplement();
        diaryServiceImplement.logIn(logInRequest);
    }

}
