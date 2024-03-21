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
        Entry entry = new Entry("Chibuzo","My love lif", "First day i met you my heart jigi papan");
        Entry entry1 = new Entry("Amebo","My first heart break","I ate till over fed my sef and finally rested in peace on my");
        entryRepositoryImplement.save(entry);
        entryRepositoryImplement.save(entry1);
        entryRepositoryImplement.delete(entry1.getTitle());
        assertEquals(1, entryRepositoryImplement.count());

    }
    @Test
    public void registerTwoEntry_findByIdTest(){
        Entry entry = new Entry("Chibuzo","My love lif", "First day i met you my heart jigi papan");
        Entry entry1 = new Entry("Amebo","My first heart break","I ate till over fed my sef and finally rested in peace on my");
        entryRepositoryImplement.save(entry);
        entryRepositoryImplement.save(entry1);
        assertEquals(entry, entryRepositoryImplement.findById(1));
    }

    @Test
    public void registerTwoEntries_entryTwoIdIs2Test(){
        Entry entry1 = new Entry("Chibuzo","My love life", "First day i met you my heart jigi papan");
        Entry entry2 = new Entry("Amebo","My first heart break","I ate till over fed my sef and finally rested in peace on my");
        entryRepositoryImplement.save(entry1);
        entryRepositoryImplement.save(entry2);
        assertEquals(entry2, entryRepositoryImplement.findById(2));
    }
}
