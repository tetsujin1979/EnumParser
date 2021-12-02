package com.enumparser;

import java.util.Deque;

import org.xml.sax.SAXException;

/**
 * Interface to process end tags in an xml file
 * @param <T> The class to process
 */
public interface EndTag<T> {

    public abstract void processElement(String namespaceURI, 
                                        String sName, 
                                        String qName, 
                                        String characters,
                                        Deque<T> deque) throws SAXException;

}
