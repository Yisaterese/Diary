package repository;

import model.Diary;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepositoryImplement implements DiaryRepository {
    private final List<Diary> diaries = new ArrayList<>();
    @Override
    public Diary save(Diary diary) {
       if(!diaries.contains(diary)) {
           diaries.add(diary);
           return diary;
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
    public void delete(String userName) {
        Diary foundDiary = findByUserName(userName);
        diaries.remove(foundDiary);

    }

    public  Diary findByUserName(String userName) {
         for (Diary diary : diaries){
            if(diary.getUserName().equalsIgnoreCase(userName)) {
                return diary;
            }
        }
         return null;
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
