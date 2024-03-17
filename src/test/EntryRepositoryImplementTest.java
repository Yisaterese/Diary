package test;

import model.Entry;
import org.junit.Test;
import repository.EntryRepositoryImplement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EntryRepositoryImplementTest {
    @Test
    public void registerEntryAndSave(){
        EntryRepositoryImplement entryRepositoryImplement = new EntryRepositoryImplement();
        Entry entry = new Entry();
        Entry entry1 = new Entry();
        entryRepositoryImplement.save(entry);
        entryRepositoryImplement.save(entry1);
        assertEquals(2, entryRepositoryImplement.count());

    }

    @Test
    public void registerTwoEntry_deleteOneEntryTes(){
        EntryRepositoryImplement entryRepositoryImplement = new EntryRepositoryImplement();
        Entry entry = new Entry();
        Entry entry1 = new Entry();
        entryRepositoryImplement.save(entry);
        entryRepositoryImplement.save(entry1);
        entryRepositoryImplement.delete(entry1);
        assertEquals(1, entryRepositoryImplement.count());

    }


    @Test
    public void registerTwoEntry_deleteOneTitleTes(){
        EntryRepositoryImplement entryRepositoryImplement = new EntryRepositoryImplement();
        Entry entry = new Entry("Chibuzo","My love lif", "First day i met you my heart jigi papan");
        Entry entry1 = new Entry("Amebo","My first heart break","I ate till over fed my sef and finally rested in peace on my");
        entryRepositoryImplement.save(entry);
        entryRepositoryImplement.save(entry1);
        entryRepositoryImplement.delete(entry1.getTitle());
        assertEquals(1, entryRepositoryImplement.count());

    }
}
