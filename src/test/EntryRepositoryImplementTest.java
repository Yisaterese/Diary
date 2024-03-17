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
        entryRepositoryImplement.save(entry);
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
}
