package test;

import model.Diary;
import org.junit.Test;
import repository.DiaryRepositoryImplement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiaryRepositoryImplementTest {


    @Test
    public  void addDiariesToRepositoryTest(){
        DiaryRepositoryImplement diaryRepositoryImplement  = new DiaryRepositoryImplement();
        Diary diary = new Diary();
        Diary diary1 = new Diary();
        diaryRepositoryImplement.save(diary);
        diaryRepositoryImplement.save(diary1);
        assertEquals(2, diaryRepositoryImplement.count());
    }

    @Test
    public  void addDiariesToRepositoryFindAllTest(){
        DiaryRepositoryImplement diaryRepositoryImplement  = new DiaryRepositoryImplement();
        Diary diary = new Diary();
        Diary diary1 = new Diary();
        diaryRepositoryImplement.save(diary);
        diaryRepositoryImplement.save(diary1);
        assertEquals(diaryRepositoryImplement.getDiaries(), diaryRepositoryImplement.findAll());
    }

    @Test
    public  void addDiariesToRepositoryDeleteOneTest(){
        DiaryRepositoryImplement diaryRepositoryImplement  = new DiaryRepositoryImplement();
        Diary diary = new Diary();
        Diary diary1 = new Diary();
        diaryRepositoryImplement.save(diary);
        diaryRepositoryImplement.save(diary1);
        diaryRepositoryImplement.delete(diary1);
        assertEquals(1, diaryRepositoryImplement.count());
    }

    @Test
    public  void addDiariesToRepositoryDeleteOneByUserNameTest(){
        DiaryRepositoryImplement diaryRepositoryImplement  = new DiaryRepositoryImplement();
        Diary diary1 = new Diary();
        diary1.setUserName("userName");
        diary1.setPassword("password");
        diaryRepositoryImplement.save(diary1);
        assertEquals(1, diaryRepositoryImplement.count());
        diaryRepositoryImplement.delete("userName");
        assertEquals(0, diaryRepositoryImplement.count());
    }


}
