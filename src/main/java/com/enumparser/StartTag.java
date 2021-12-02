package com.enumparser;

import java.util.Deque;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * Interface to process opening tags in an XML file
 * @param <T> The type of class to process
 */
public interface StartTag<T> {

    public abstract void processElement(String namespaceURI, 
                                        String lName, 
                                        String qName,
                                        Attributes attributes,
                                        Deque<T> deque) throws SAXException;

}
