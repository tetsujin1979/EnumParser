package com.enumparser.book.model;

import java.time.LocalDate;

/**
 * Bean class of a book
 */
public class Book {

    private Long id;
    
    private String title;
    private String author;
    private String isbn;
    
    private LocalDate publishDate;
    
    public Book(Long id) {
        this.id = id;    
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public LocalDate getPublishDate() {
        return publishDate;
    }
    
    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        
        StringBuilder value = new StringBuilder("Book: " + id);
        value.append("\nTitle: " + title);
        value.append("\nAuthor: " + author);
        value.append("\nISBN: " + isbn);
        value.append("\nPublished On: " + publishDate);
        return value.toString();
        
    }
    
}
