package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
    @NotBlank(message = "Book name is required")
    private String name;

    @NotBlank(message = "Author name is required")
    private String author;

    @Min(value = 1, message = "Price must be greater than 0")
    private int price;

     public Book() {
     }

    public Book(String name, String author, int price) {
    this.name = name;
    this.author = author;
    this.price = price;
     }
    
     public int getId(){
        return this.id;
     }
     public String getName(){
        return name;
     }
     public String getAuthor(){
        return author;
     }
     public int getPrice(){
        return price;
     }


     public void setId(int id){
        this.id=id;
     }
     public void setName(String name){
        this.name=name;
     }
     public void setAuthor(String author){
        this.author=author;
     }
     public void setPrice(int price){
        this.price=price;
     }

}
