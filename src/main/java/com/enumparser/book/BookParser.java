package com.enumparser.book;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.enumparser.book.model.Book;

/**
 * Example of a parser using enumerations to parse XML
 */
public class BookParser extends DefaultHandler {

    private Deque<Book> deque;
    
    private Map<Long, Book> books; 

    private String characters;
    
    public BookParser(String fileName) {
        
        try {
            
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            parser.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
            parser.parse(new File(fileName), this);
            
        } catch (ParserConfigurationException | SAXException | IOException e) {
            
            System.err.print("Exception occured parsing file " + fileName);
            System.exit(-1);
            
        } 
        
    }
    
    @Override
    public void startDocument() throws SAXException {
        
        this.deque = new ArrayDeque<>();
        this.books = new HashMap<>();
        
    }
    
    @Override
    public void startElement(String namespaceURI, String lName, String qName,
            Attributes attributes) throws SAXException {
        
        BookStartTag bookStartTag = BookStartTag.fromTagName(qName);
        if (bookStartTag != null) {
            
            bookStartTag.processElement(namespaceURI, lName, qName, attributes, deque);
            
        }
        
    }

    @Override
    public void endElement(String namespaceURI, String sName, String qName)
            throws SAXException {
        
        BookEndTag bookEndTag = BookEndTag.fromTagName(qName);
        if (bookEndTag != null) {
            
            bookEndTag.processElement(namespaceURI, sName, qName, characters, deque);
            
        }
        if (qName.equals("book")) {
            
            Book book = deque.pop();
            books.put(book.getId(), book);
            
        }

    }

    @Override
    public void characters(char[] buf, int offset, int len) throws SAXException {
        this.characters = new String(buf, offset, len);
    }

    public Book getBookById(Long id) {
        
        return books.get(id);
        
    }
    
}
