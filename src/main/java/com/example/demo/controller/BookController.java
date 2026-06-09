package com.example.demo.controller;
import org.springframework.stereotype.Controller;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class BookController {

    @Autowired
    private BookRepository brp;

     @GetMapping("/")
    public String home(Model model){
        model.addAttribute("books", brp.findAll());
        return "index";
    }


    @GetMapping("/add")
    public String addBookPage(Model model) {
    model.addAttribute("book", new Book());
    return "addbook";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book book) {
    brp.save(book);
    return "redirect:/";
    }
    
}
