package repository;

import model.Diary;

import java.util.List;

public interface DiaryRepository {
    Diary save(Diary diary);
    List<Diary> findAll();
    long count();
    void delete(String username);
    void delete(Diary diary);
}
