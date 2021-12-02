package com.enumparser.book;

import java.util.Deque;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.enumparser.StartTag;
import com.enumparser.book.model.Book;

/**
 * Enumeration to handle opening tags in an xml file
 */
public enum BookStartTag implements StartTag<Book> {

    BOOK("book") {
        
        @Override
        public void processElement(String namespaceURI, 
                                   String lName, 
                                   String qName,
                                   Attributes attributes,
                                   Deque<Book> deque) throws SAXException {

            Long id = Long.valueOf(attributes.getValue("id"));
            Book book = new Book(id);
            deque.push(book);

        }

    };
    
    private final String tagName;

    // Map of tag names to the enumeration value to process that tag
    private static final Map<String, BookStartTag> ENUM_MAP =
            Stream.of(values()).collect(Collectors.toMap(BookStartTag::getTagName, e -> e));

    BookStartTag(String tagName) {
        
        this.tagName = tagName;
                
    }
    
    public String getTagName() {
        
        return tagName;
        
    }
    
    public static BookStartTag fromTagName(String tagName) {
        
        return ENUM_MAP.get(tagName);
        
    }
        

}
