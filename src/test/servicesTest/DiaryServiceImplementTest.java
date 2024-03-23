package test.servicesTest;
import dto.request.EntryRequest;
import InvalidPasswordException.InvalidPasswordException;
import InvalidUserNameException.InvalidUserNameException;
import dto.request.LogInRequest;
import dto.request.RegisterRequest;
import model.Diary;
import model.Entry;
import org.junit.Test;
import repository.DiaryRepositoryImplement;
import services.DiaryServiceImplement;

import static org.junit.jupiter.api.Assertions.*;
public class DiaryServiceImplementTest {

    @Test
    public void registerDiaryWithUserNameAndPasswordTest(){
        DiaryServiceImplement diaryServiceImplement = new DiaryServiceImplement();
        RegisterRequest registerRequest = new RegisterRequest();
        Diary diary = new Diary();
        registerRequest.setUserName("userName");
        registerRequest.setPassword("password");
        diary.setUserName(registerRequest.getUserName());
        diary.setPassword(registerRequest.getPassword());
        diaryServiceImplement.register(registerRequest);

        assertEquals(1, diaryServiceImplement.numberOfDiaries());
    }
    @Test
    public void loginToDiaryTest(){
        DiaryServiceImplement diaryServiceImplement = new DiaryServiceImplement();
        DiaryRepositoryImplement repositoryImplement = new DiaryRepositoryImplement();
        RegisterRequest  registerRequest = new RegisterRequest();
        LogInRequest logInRequest = new LogInRequest();
        Diary diary = new Diary();
        registerRequest.setUserName("username");
        registerRequest.setPassword("password");
        diary.setUserName(registerRequest.getUserName());
        diary.setPassword(registerRequest.getPassword());
        diaryServiceImplement.register(registerRequest);
        logInRequest.setUserName(registerRequest.getUserName());
        logInRequest.setPassword(registerRequest.getPassword());
        diary.setUserName(logInRequest.getUserName());
        diary.setPassword(logInRequest.getPassword());
        diaryServiceImplement.logIn(logInRequest);
        assertTrue(diary.isUnlocked());
    }
    @Test
    public void logOutOfDiaryTest(){
        DiaryServiceImplement diaryServiceImplement = new DiaryServiceImplement();
        DiaryRepositoryImplement repositoryImplement = new DiaryRepositoryImplement();
        RegisterRequest  registerRequest = new RegisterRequest();
        LogInRequest logInRequest = new LogInRequest();
        Diary diary = new Diary();
        registerRequest.setUserName("username");
        registerRequest.setPassword("password");
        diary.setUserName(registerRequest.getUserName());
        diary.setPassword(registerRequest.getPassword());
        diaryServiceImplement.register(registerRequest);
        logInRequest.setUserName(registerRequest.getUserName());
        logInRequest.setPassword(registerRequest.getPassword());
        diary.setUserName(logInRequest.getUserName());
        diary.setPassword(logInRequest.getPassword());
        diaryServiceImplement.logIn(logInRequest);
        diaryServiceImplement.logOut();
        assertFalse(diary.isLocked());
    }
    @Test
    public void logIntoDiaryWithWrongUserNameThrowInvalidUsernameExceptionTest(){
        DiaryServiceImplement diaryServiceImplement = new DiaryServiceImplement();
        DiaryRepositoryImplement repositoryImplement = new DiaryRepositoryImplement();
        RegisterRequest  registerRequest = new RegisterRequest();
        LogInRequest logInRequest = new LogInRequest();
        Diary diary = new Diary();
        registerRequest.setUserName("username");
        registerRequest.setPassword("password");
        diary.setUserName(registerRequest.getUserName());
        diary.setPassword(registerRequest.getPassword());
        diaryServiceImplement.register(registerRequest);
        logInRequest.setUserName("userName");
        logInRequest.setPassword(registerRequest.getPassword());
        assertThrows(InvalidUserNameException.class, () -> diaryServiceImplement.logIn(logInRequest));
    }
    @Test
    public void loginToDiaryWithWrongPasswordThrowInvalidPasswordExceptionTest(){
        DiaryServiceImplement diaryServiceImplement = new DiaryServiceImplement();
        DiaryRepositoryImplement repositoryImplement = new DiaryRepositoryImplement();
        RegisterRequest  registerRequest = new RegisterRequest();
        LogInRequest logInRequest = new LogInRequest();
        Diary diary = new Diary();
        registerRequest.setUserName("username");
        registerRequest.setPassword("password");
        diary.setUserName(registerRequest.getUserName());
        diary.setPassword(registerRequest.getPassword());
        diaryServiceImplement.register(registerRequest);
        logInRequest.setUserName("username");
        logInRequest.setPassword("PassWord");
        assertThrows(InvalidPasswordException.class, () -> diaryServiceImplement.logIn(logInRequest));
    }
    @Test
    public void loginToDiaryWithWrongUsernameAndPasswordThrowInvalidUsernameExceptionAndInvalidPasswordExceptionTest(){
        DiaryServiceImplement diaryServiceImplement = new DiaryServiceImplement();
        DiaryRepositoryImplement repositoryImplement = new DiaryRepositoryImplement();
        RegisterRequest  registerRequest = new RegisterRequest();
        LogInRequest logInRequest = new LogInRequest();
        Diary diary = new Diary();
        registerRequest.setUserName("username");
        registerRequest.setPassword("password");
        diary.setUserName(registerRequest.getUserName());
        diary.setPassword(registerRequest.getPassword());
        diaryServiceImplement.register(registerRequest);
        logInRequest.setUserName("userName");
        assertThrows(InvalidUserNameException.class, () -> diaryServiceImplement.logIn(logInRequest));
        logInRequest.setPassword("PassWord");
        assertThrows(InvalidPasswordException.class, () -> diaryServiceImplement.logIn(logInRequest));
    }
    @Test
    public void createEntryInDiary_findTitleTest(){
        EntryRequest entryRequest = new EntryRequest();
        DiaryServiceImplement diaryServiceImplement = new DiaryServiceImplement();
        RegisterRequest registerRequest = new RegisterRequest();
        Diary diary = new Diary();
        Entry entry = new Entry();

        registerRequest.setUserName("userName");
        registerRequest.setPassword("password");
        diary.setUserName(registerRequest.getUserName());
        diary.setPassword(registerRequest.getPassword());
        diaryServiceImplement.register(registerRequest);
        entry.setAuthor("Ade");

        entryRequest.setTitle("My love life");
        entryRequest.setBody("e dey sweet me for body");
        entry.setAuthor(entryRequest.getAuthor());
        entry.setTitle(entryRequest.getTitle());
        entry.setBody(entryRequest.getBody());
        diaryServiceImplement.createEntry(entryRequest);

        assertEquals(diary.getEntry());
    }
}
