package test;

import dto.request.RegisterRequest;
import model.Diary;
import org.junit.Test;
import repository.DiaryRepositoryImplement;
import services.DiaryServiceImplement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiaryServiceImplementTest {
    @Test
    public void registerDiaryWithUserNameAndPassword(){
        DiaryServiceImplement diaryServiceImplement = new DiaryServiceImplement();
        RegisterRequest request = new RegisterRequest("UserName", "Password");
        diaryServiceImplement.register(request);
        assertEquals(1, diaryServiceImplement.numberOfDiaries());

    }

    @Test
    public void registerDiary(){
        DiaryServiceImplement diaryServiceImplement = new DiaryServiceImplement();
        RegisterRequest request = new RegisterRequest("UserName", "Password");
        diaryServiceImplement.register(request);
        assertEquals(1, diaryServiceImplement.numberOfDiaries());

    }
}
