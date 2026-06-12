package com.example.demo.controller;
import org.springframework.stereotype.Controller;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;




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
    public String saveBook(@Valid @ModelAttribute Book book,BindingResult result) {
    if(result.hasErrors()) {
        return "addbook";
    }
    brp.save(book);
    return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id){
    brp.deleteById(id);
    return "redirect:/";
    }
    
    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable int id, Model model){
    Book book = brp.findById(id).orElse(null);
    model.addAttribute("book", book);
    return "addbook";
    }

    @GetMapping("/search")
    public String searchBook(@RequestParam String keyword,Model model) {
    model.addAttribute(
            "books",
            brp.findByNameContainingIgnoreCase(keyword)
    );
    return "index";
    }
    
}
