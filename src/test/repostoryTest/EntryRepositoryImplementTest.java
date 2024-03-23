package test.repostoryTest;

import model.Entry;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import repository.EntryRepositoryImplement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntryRepositoryImplementTest {
    private EntryRepositoryImplement entryRepositoryImplement;
    @Before
    public void initializer(){
        entryRepositoryImplement = new EntryRepositoryImplement();
    }
    @AfterEach
    public void tearDownContainer(){
        entryRepositoryImplement.findAll().clear();
    }
    @Test
    public void registerEntryAndSave(){
        Entry entry = new Entry();
        Entry entry1 = new Entry();
        entryRepositoryImplement.save(entry);
        entryRepositoryImplement.save(entry1);
        assertEquals(2, entryRepositoryImplement.count());

    }
    @Test
    public void registerTwoEntry_deleteOneEntryTes(){
        Entry entry = new Entry();
        Entry entry1 = new Entry();
        entryRepositoryImplement.save(entry);
        entryRepositoryImplement.save(entry1);
        entryRepositoryImplement.delete(entry1);
        assertEquals(1, entryRepositoryImplement.count());

    }
    @Test
    public void registerTwoEntry_deleteOneByTitleTest(){
        Entry entry1 = new Entry();
        Entry entry2 = new Entry();
        entry1.setAuthor("Chibuzo");
        entry1.setTitle("My love life");
        entry1.setBody("First day i met you my heart jigi papan");
        entryRepositoryImplement.save(entry1);

        entry2.setAuthor("Amebo");
        entry2.setTitle("My first heart break");
        entry2.setBody("I ate till over fed my sef and finally rested in peace on my");
        entryRepositoryImplement.save(entry2);

        entryRepositoryImplement.delete(entry1.getTitle());
        assertEquals(1, entryRepositoryImplement.count());

    }
    @Test
    public void registerTwoEntry_findByIdTest(){
        Entry entry1 = new Entry();
        Entry entry2 = new Entry();
        entry1.setAuthor("Chibuzo");
        entry1.setTitle("My love life");
        entry1.setBody("First day i met you my heart jigi papan");
        entryRepositoryImplement.save(entry1);

        entry2.setAuthor("Amebo");
        entry2.setTitle("My first heart break");
        entry2.setBody("I ate till over fed my sef and finally rested in peace on my");
        entryRepositoryImplement.save(entry2);

        assertEquals(entry1, entryRepositoryImplement.findById(1));
    }
    @Test
    public void registerTwoEntries_entryTwoIdIs2Test(){
        Entry entry = new Entry();
        Entry entry1 = new Entry();
        entry.setAuthor("Chibuzo");
        entry.setTitle("My love life");
        entry.setBody("First day i met you my heart jigi papan");
        entryRepositoryImplement.save(entry);

        entry1.setAuthor("Amebo");
        entry1.setTitle("My first heart break");
        entry1.setBody("I ate till over fed my sef and finally rested in peace on my");
        entryRepositoryImplement.save(entry1);

        assertEquals(entry1, entryRepositoryImplement.findById(2));
    }
}
