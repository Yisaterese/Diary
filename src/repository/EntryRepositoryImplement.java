package repository;

import model.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImplement implements EntryRepository{
    private List<Entry> entries = new ArrayList<>();
    public void save(String body, String title) {
        if( == null) entries.add(entry);


    }

    public long count() {
        return entries.size();
    }
}
