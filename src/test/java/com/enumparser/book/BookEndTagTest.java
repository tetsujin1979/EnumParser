package com.enumparser.book;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Before;
import org.junit.Test;

import com.enumparser.book.model.Book;

/**
 * Unit tests for {@link BookEndTag}
 */
public class BookEndTagTest {

	private final String nameSpaceURI = "nameSpaceURI";
	private final String sName = "sName";
	private final String qName = "qName";
	
	private Deque<Book> deque;
	
	@Before
	public void setup() {
		
		deque = new ArrayDeque<>();
		deque.push(new Book(1L));
				
	}
	
	/**
	 * Unit tests for {@link BookEndTag#AUTHOR}
	 */
	@Test
	public void testAuthor() throws Exception {
		
		String author = "author";
		BookEndTag.AUTHOR.processElement(nameSpaceURI, sName, qName, author, deque);
		Book book = deque.pop();
		assertEquals("Unexpected book author", author, book.getAuthor());
		
	}
	
	/**
	 * Unit tests for {@link BookEndTag#ISBN}
	 */
	@Test
	public void testIsbn() throws Exception {
		
		String isbn = "isbn";
		BookEndTag.ISBN.processElement(nameSpaceURI, sName, qName, isbn, deque);
		Book book = deque.pop();
		assertEquals("Unexpected book isbn", isbn, book.getIsbn());
		
	}
	
	/**
	 * Unit tests for {@link BookEndTag#PUBLISH_DATE}
	 */
	@Test
	public void testPublishDate() throws Exception {
		
		LocalDate publishDate = LocalDate.now();
		BookEndTag.PUBLISH_DATE.processElement(nameSpaceURI, sName, qName, publishDate.toString(), deque);
		Book book = deque.pop();
		assertEquals("Unexpected book publish date", publishDate, book.getPublishDate());
		
	}
	
	/**
	 * Unit tests for {@link BookEndTag#Title}
	 */
	@Test
	public void testTitle() throws Exception {
		
		String title = "title";
		BookEndTag.TITLE.processElement(nameSpaceURI, sName, qName, title, deque);
		Book book = deque.pop();
		assertEquals("Unexpected book title", title, book.getTitle());
		
	}
	
}
