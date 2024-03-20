package services;

import dto.request.RegisterRequest;
import model.Diary;
import repository.DiaryRepositoryImplement;

public class DiaryServiceImplement implements DiaryService{
    private final DiaryRepositoryImplement diaryRepositoryImplement = new DiaryRepositoryImplement();
    private boolean isLocked;
    @Override
    public long numberOfDiaries() {
        return diaryRepositoryImplement.count();
    }

    @Override
    public void register(RegisterRequest request) {
      Diary diary = new Diary();
      diary.setUserName(request.getUserName());
      diary.setPassword(request.getPassword());
      diaryRepositoryImplement.save(diary);

    }

    @Override
    public void logIn(String userName, String password ) {
        //RegisterRequest request1 = new RegisterRequest()
        Diary diary = new Diary();
        diary.setPassword(request.getPassword());


    }

}
