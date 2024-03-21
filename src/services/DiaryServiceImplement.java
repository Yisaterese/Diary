package services;

import InvalidUserNameException.InvalidUserNameException;
import dto.request.RegisterRequest;
import model.Diary;
import repository.DiaryRepositoryImplement;

public class DiaryServiceImplement implements DiaryService{
    private final DiaryRepositoryImplement diaryRepositoryImplement = new DiaryRepositoryImplement();
    private boolean isLocked;
    private  RegisterRequest request1;
    @Override
    public long numberOfDiaries() {
        return diaryRepositoryImplement.count();
    }

    @Override
    public void register(RegisterRequest request) {
        if(!isLocked) {
            Diary diary = new Diary();
            diary.setUserName(request.getUserName());
            diary.setPassword(request.getPassword());
            diaryRepositoryImplement.save(diary);
        }
    }

    @Override
    public boolean logIn(String userName, String password) {
            RegisterRequest request = new RegisterRequest();
            DiaryRepositoryImplement diaryRepositoryImplement1 = new DiaryRepositoryImplement();
            Diary foundDiary = diaryRepositoryImplement1.findByUserName(userName);
            if(!foundDiary.getUserName().equals(userName))throw new InvalidUserNameException("provided username not found");
            request.setPassword(password);
            if(!foundDiary.&& foundDiary.setPassword(request1.getPassword())));

            Diary diary = new Diary();
            request1.setUserName(userName);
            diary.setUserName(request1.getUserName());
            request1.setPassword(password);
            diary.setPassword(request1.getPassword());
            if(request1.getUserName().equals(userName) && request1.getPassword().equals(password)){
                return true;
            }
         return false;
    }

    public boolean unlock() {
        isLocked = true;
        return true;
    }
}
