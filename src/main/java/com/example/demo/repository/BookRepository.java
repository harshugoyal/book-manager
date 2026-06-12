package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Book;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByNameContainingIgnoreCase(String name);
}
