package services;

import InvalidPasswordException.InvalidPasswordException;
import InvalidUserNameException.InvalidUserNameException;
import InvalidUsernameAndPasswordException.InvalidUsernameAndPasswordException;
import dto.request.EntryRequest;
import dto.request.LogInRequest;
import dto.request.RegisterRequest;
import model.Diary;
import repository.DiaryRepository;
import repository.DiaryRepositoryImplement;

public class DiaryServiceImplement implements DiaryService{
    private final DiaryRepository diaryRepositoryImplement = new DiaryRepositoryImplement();
    private  RegisterRequest request;
    private    Diary diary = new Diary();
    @Override
    public long numberOfDiaries(){
        return diaryRepositoryImplement.count();
    }
    @Override
    public void register(RegisterRequest request){
            diary.setUserName(request.getUserName());
            diary.setPassword(request.getPassword());
            diaryRepositoryImplement.save(diary);
    }
    @Override
    public void logIn(LogInRequest logInRequest){
        Diary foundDiary = diaryRepositoryImplement.findByUserName(logInRequest.getUserName());
        if(!findUserName(logInRequest)) throw new InvalidUserNameException("provided username not found");
        if(!findPassword(logInRequest))throw new InvalidPasswordException("invalid password provided");
        if(!findUserName(logInRequest) && findPassword(logInRequest)) throw new InvalidUsernameAndPasswordException("Wrong username and password");
        //if(!foundDiary.getPassword().equals(logInRequest.getPassword()) && foundDiary.getUserName().equals(logInRequest.getUserName())) throw new InvalidUsernameAndPasswordException("Wrong username and password");
        diaryRepositoryImplement.save(foundDiary);
        foundDiary.setLock(true);
    }
    public void logOut(){
      diary.setLock(false);
    }
    private boolean findPassword(LogInRequest logInRequest){
        Diary foundDiary = diaryRepositoryImplement.findByUserName(logInRequest.getUserName());
        if(foundDiary.getPassword().equals(logInRequest.getPassword())){return true;}

        return false;
    }
    private boolean findUserName(LogInRequest logInRequest){
        Diary foundDiary = diaryRepositoryImplement.findByUserName(logInRequest.getUserName());
        if(foundDiary.getUserName().equals(logInRequest.getUserName())){return  true;}

        return false;
    }

    public void createEntry(EntryRequest entryRequest) {
    }
}