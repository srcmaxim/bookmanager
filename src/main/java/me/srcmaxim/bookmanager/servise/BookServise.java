package me.srcmaxim.bookmanager.servise;

import me.srcmaxim.bookmanager.model.Book;

import java.util.List;

public interface BookServise {
    List<Book> findAll();
    Book findById(Long id);
    Book create(Book user);
    Book edit(Book user);
    void deleteById(Long id);
}
