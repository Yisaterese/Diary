package test.controllersTest;

import controllers.DiaryController;
import dto.request.RegisterRequest;
import model.Diary;
import org.junit.Test;
import services.DiaryServiceImplement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiaryControllerTest {
    @Test
    public  void diaryControllerLoginTest(){
        DiaryController diaryController = new DiaryController();
        Diary diary = new Diary();
        RegisterRequest request = new RegisterRequest();
        request.setUserName("UserName");
        diary.setUserName(request.getUserName());
        request.setPassword("password");
        diary.setUserName(request.getPassword());
        DiaryServiceImplement diaryServiceImplement = new DiaryServiceImplement();
        diaryServiceImplement.register(request);
        assertTrue();
    }
}
