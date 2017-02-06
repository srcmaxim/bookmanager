package me.srcmaxim.bookmanager.servise;

import me.srcmaxim.bookmanager.model.Book;
import me.srcmaxim.bookmanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class HiberanteBookServise implements BookServise {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public Book create(Book user) {
        return bookRepository.save(user);
    }

    @Override
    public Book edit(Book user) {
        return bookRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.delete(id);
    }
}
