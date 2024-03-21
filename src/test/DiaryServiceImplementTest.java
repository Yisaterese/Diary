package test;

import dto.request.RegisterRequest;
import model.Diary;
import org.junit.Test;
import repository.DiaryRepositoryImplement;
import services.DiaryServiceImplement;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryServiceImplementTest {
    @Test
    public void registerDiaryWithUserNameAndPassword(){
        DiaryServiceImplement diaryServiceImplement = new DiaryServiceImplement();
        RegisterRequest request = new RegisterRequest();
        diaryServiceImplement.register(request);
        assertEquals(1, diaryServiceImplement.numberOfDiaries());

    }

    @Test
    public void registerDiaryTest(){
        DiaryServiceImplement diaryServiceImplement = new DiaryServiceImplement();
        RegisterRequest request = new RegisterRequest();
        diaryServiceImplement.register(request);
        assertEquals(1, diaryServiceImplement.numberOfDiaries());
    }

    @Test
    public void loginToDiary(){
        DiaryServiceImplement diaryServiceImplement = new DiaryServiceImplement();
        DiaryRepositoryImplement repositoryImplement = new DiaryRepositoryImplement();
        RegisterRequest request = new RegisterRequest();
        Diary diary = new Diary();
        request.setUserName("userName");
        diary.setUserName(request.getUserName());
        request.setPassword("password");
        diary.setPassword(request.getPassword());
        repositoryImplement.save(diary);
        diaryServiceImplement.register(request);
        assertFalse( diaryServiceImplement.logIn(request.getUserName(), request.getPassword()));
    }
}
