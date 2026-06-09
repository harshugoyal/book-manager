package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BookController {

    @Autowired
    private BookRepository brp;

     @GetMapping("/")
    public String home(Model model){

        model.addAttribute("books", brp.findAll());

        return "index";
    }
    
}
