package test.repostoryTest;

import model.Diary;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import repository.DiaryRepositoryImplement;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class DiaryRepositoryImplementTest {
private  DiaryRepositoryImplement diaryRepositoryImplement;
@Before
public void initializer(){
    diaryRepositoryImplement  = new DiaryRepositoryImplement();
}
    @AfterEach
    public void collapseList(){
        diaryRepositoryImplement.findAll().clear();
    }
    @Test
    public  void addDiariesToRepositoryTest(){

        Diary diary = new Diary();
        Diary diary1 = new Diary();
        diaryRepositoryImplement.save(diary);
        diaryRepositoryImplement.save(diary1);
        assertEquals(2, diaryRepositoryImplement.count());
    }
    @Test
    public  void addDiariesToRepositoryFindAllTest(){
        Diary diary = new Diary();
        Diary diary1 = new Diary();
        diaryRepositoryImplement.save(diary);
        diaryRepositoryImplement.save(diary1);
        assertEquals(diaryRepositoryImplement.getDiaries(), diaryRepositoryImplement.findAll());
    }
    @Test
    public  void addDiariesToRepositoryDeleteOneTest(){

        Diary diary = new Diary();
        Diary diary1 = new Diary();
        diaryRepositoryImplement.save(diary);
        diaryRepositoryImplement.save(diary1);
        diaryRepositoryImplement.delete(diary1);
        assertEquals(1, diaryRepositoryImplement.count());
    }
    @Test
    public  void addDiariesToRepositoryDeleteOneByUserNameTest(){
        Diary diary1 = new Diary();
        diary1.setUserName("userName");
        diary1.setPassword("password");
        diaryRepositoryImplement.save(diary1);
        assertEquals(1, diaryRepositoryImplement.count());
        diaryRepositoryImplement.delete("userName");
        assertEquals(0, diaryRepositoryImplement.count());
    }
    @Test
    public  void addDiariesToRepositoryDeleteOneByUserNameReturnDiaryTest(){
        Diary diary = new Diary();
        diary.setUserName("userName");
        diary.setPassword("password");
        diaryRepositoryImplement.save(diary);
        assertEquals(1, diaryRepositoryImplement.count());
        assertEquals(diary, diaryRepositoryImplement.findByUserName(diary.getUserName()));
    }


}
