package repository;

import model.Diary;

import java.util.List;
import model.Entry;

public interface EntryRepository {
    Diary save(Entry entry);
    List<Entry> findAll();
    long count();
    void delete(String title);
    void delete(Entry entry);
}
