package repository;

import model.Diary;
import model.Entry;
import org.junit.jupiter.api.TestInfo;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImplement implements EntryRepository{
    private List<Entry> entries = new ArrayList<>();

    @Override
    public Diary save(Entry entry) {
            if (!entries.contains(entry))
                entries.add(entry);
            return null;
    }

    @Override
    public List<Entry> findAll() {
        return entries;
    }

    @Override
    public long count() {
        return entries.size();
    }

    @Override
    public void delete(String title) {
        for(Entry myEntry : entries){
            if (myEntry.getTitle().equals(title)) {
                entries.remove(myEntry);
                break;
            }
        }
    }

    @Override
    public void delete(Entry entry) {
        for(Entry myEntry : entries){
            if (myEntry == entry) {
                entries.remove(myEntry);
                break;
            }
        }
    }
}
