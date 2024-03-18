package services;

import dto.request.RegisterRequest;
import model.Diary;
import repository.DiaryRepositoryImplement;

public class DiaryServiceImplement implements DiaryService{
    private final DiaryRepositoryImplement diaryRepositoryImplement = new DiaryRepositoryImplement();

    @Override
    public long numberOfDiaries() {
        return diaryRepositoryImplement.count();
    }

    @Override
    public void register(RegisterRequest request) {
      Diary diary = new Diary();
      diary.setUserName(request.getUserName());
      diaryRepositoryImplement.save(diary);
      diary.setPassword(request.getPassword());
      diaryRepositoryImplement.save(diary);
    }

    @Override
    public void logIn() {
    }

}
