package com.enumparser.book;

import java.time.LocalDate;
import java.util.Deque;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.xml.sax.SAXException;

import com.enumparser.EndTag;
import com.enumparser.book.model.Book;

/**
 * Enumeration to handle closing tags in books.xml
 */
public enum BookEndTag implements EndTag<Book> {

    AUTHOR("author"){
        
        public void processElement(String namespaceURI, 
                                   String sName, 
                                   String qName, 
                                   String characters,
                                   Deque<Book> deque) throws SAXException {
            
            Book book = deque.peek();
            book.setAuthor(characters);
            
        }

    },
    ISBN("isbn"){
        
        public void processElement(String namespaceURI, 
                                   String sName, 
                                   String qName, 
                                   String characters,
                                   Deque<Book> deque) throws SAXException {
            
            Book book = deque.peek();
            book.setIsbn(characters);
            
        }

    },
    PUBLISH_DATE("publishDate"){
        
        public void processElement(String namespaceURI, 
                                   String sName, 
                                   String qName, 
                                   String characters,
                                   Deque<Book> deque) throws SAXException {
            
            Book book = deque.peek();
            LocalDate publishDate = LocalDate.parse(characters);
            book.setPublishDate(publishDate);
            
        }

    },
    TITLE("title") {
        
        public void processElement(String namespaceURI, 
                                   String sName, 
                                   String qName, 
                                   String characters,
                                   Deque<Book> deque) throws SAXException {
            
            Book book = deque.peek();
            book.setTitle(characters);
            
        }

    };
    
    private String tagName;

    // Map of tag names to an enumeration value to process that tag
    private static final Map<String, BookEndTag> ENUM_MAP =
            Stream.of(values())
                  .collect(Collectors.toMap(BookEndTag::getTagName, e -> e));

    BookEndTag(String tagName) {
        
        this.tagName = tagName;
                
    }
    
    public String getTagName() {
        
        return tagName;
        
    }
    
    public static BookEndTag fromTagName(String tagName) {
        
        return ENUM_MAP.get(tagName);
        
    }
 
}
