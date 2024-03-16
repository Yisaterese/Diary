package repository;

import model.Diary;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepositoryImplement implements DiaryRepository {
    private List<Diary> diaries = new ArrayList<>();
    @Override
    public Diary save(Diary diary) {
       if(!diaries.contains(diary)) {
           diaries.add(diary);
       }
       return null;

    }

    @Override
    public List<Diary> findAll() {
       return diaries;
    }

    @Override
    public long count() {
        return diaries.size();
    }

    @Override
    public void delete(String username) {
        for (Diary myDiary:diaries)
            if(myDiary.getUserName().equals(username)){
                diaries.remove(myDiary);
                break;

            }
    }

    @Override
    public void delete(Diary diary) {
        for (Diary myDiary:diaries)
            if(myDiary == diary){
                diaries.remove(myDiary);
                    break;
            }



    }

    public List getDiaries() {
        return diaries;
    }
}
