package repository;

import model.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImplement implements EntryRepository {
    private List<Entry> entries = new ArrayList<>();
    private int count;


    @Override
    public Entry save(Entry entry) {
        if(isNew(entry)) entries.add(entry);
        else update(entry);
        return null;
    }

    private void update(Entry entry) {
        for(Entry myEntry: entries) if(myEntry == entry)delete(myEntry);
        entries.add(entry);
    }

    private boolean isNew(Entry entry) {
            if(!entries.contains(entry)){
                entry.setId(++count);
            };
        return false;
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
        for (Entry myEntry : entries) {
            if (myEntry.getTitle().equals(title)) {
                entries.remove(myEntry);
                break;
            }
        }
    }

    @Override
    public void delete(Entry entry) {
        for (Entry myEntry : entries) {
            if (myEntry == entry) {
                entries.remove(myEntry);
                break;
            }
        }
    }

    public Entry findById(int id) {
        for (Entry myEntry : entries) {
            if (myEntry.getId() == id) {
                return myEntry;
            }
        }
        return null;
    }
}