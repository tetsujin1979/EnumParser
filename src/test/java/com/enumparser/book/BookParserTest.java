package com.enumparser.book;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.enumparser.book.model.Book;

/**
 * Unit tests for {@link BookParser}
 */
public class BookParserTest {

    private BookParser bookParser;
    
    @Before
    public void setup() {
        
        bookParser = new BookParser("books.xml");
        
    }
    
    /**
     * Unit test for books.xml
     */
    @Test
    public void test() {
            
        Book book = bookParser.getBookById(1L);
        assertNotNull("Expected book to not be null", book);
        
    }

}
