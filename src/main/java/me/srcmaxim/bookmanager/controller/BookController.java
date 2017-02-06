package me.srcmaxim.bookmanager.controller;

import me.srcmaxim.bookmanager.model.Book;
import me.srcmaxim.bookmanager.servise.BookServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    private BookServise bookServise;

    @Autowired
    public void setBookServise(BookServise bookServise) {
        this.bookServise = bookServise;
    }

    @RequestMapping("/")
    public String index() {
        return "/index";
    }

    @RequestMapping("/book")
    public String book(Model model) {
        return "redirect:/book/list";
    }

    @RequestMapping("/book/list")
    public String listBooks(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("bookList", bookServise.findAll());
        return "/books";
    }

    @RequestMapping(value = "/book/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book) {
        bookServise.create(book);
        return "redirect:/book/list";
    }

    @RequestMapping("/book/remove/{id}")
    public String removeBook(@PathVariable("id") long id) {
        bookServise.deleteById(id);
        return "redirect:/book/list";
    }

    @RequestMapping(value = "/book/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("book", bookServise.findById(id));
        return "/editbook";
    }

    @RequestMapping(value = "/book/edit/{id}", method = RequestMethod.POST)
    public String editBookEdit(@PathVariable(value = "id") long id, @ModelAttribute("book") Book book) {
        book.setId(id);
        bookServise.edit(book);
        return "redirect:/book/list";
    }

    @RequestMapping("/book/{id}")
    public String bookData(@PathVariable("id") long id, Model model) {
        model.addAttribute("book", bookServise.findById(id));
        return "/book";
    }

}
