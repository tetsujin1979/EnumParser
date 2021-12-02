package com.enumparser.book;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.Attributes;

import com.enumparser.book.model.Book;

/**
 * Unit tests for {@link BookStartTag}
 */
public class BookStartTagTest {

	private final String nameSpaceURI = "nameSpaceURI";
	private final String lName = "lName";
	private final String qName = "qName";
	
	private Attributes mockAttributes;
		
	private Deque<Book> deque;

	@Before
	public void setup() {

		mockAttributes = mock(Attributes.class);
		deque = new ArrayDeque<>();

	}
	/**
	 * Unit test for {@link BookStartTag#BOOK}
	 */
	@Test
	public void testBook() throws Exception {

		when(mockAttributes.getValue("id")).thenReturn("1");
		BookStartTag.BOOK.processElement(nameSpaceURI, lName, qName, mockAttributes, deque);
		assertEquals("Unexpected number of elements in deque", 1, deque.size());
		
		Book book = deque.pop();
		assertEquals("Unexpected id value for book in deque", Long.valueOf(1L), book.getId());

	}

}
