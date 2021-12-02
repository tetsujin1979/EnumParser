package com.enumparser.book.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for {@link Book}
 */
public class BookTest {

	private Book book;
	
	private LocalDate publishDate;
	
	@Before
	public void setup() {
	
		publishDate = LocalDate.now();
		
		book = new Book(1L);
		book.setAuthor("Author");
		book.setIsbn("ISBN 1234 5678");
		book.setPublishDate(publishDate);
		book.setTitle("Title");
		
		
	}
	
	/**
	 * Unit tests for {@link Book#toString}
	 */
	@Test
	public void testToString() {
		
		StringBuilder expected = new StringBuilder("Book: 1\n").append("Title: Title\n")
															   .append("Author: Author\n")
															   .append("ISBN: ISBN 1234 5678\n")
															   .append("Published On: " + publishDate.toString());
		
		assertEquals("Unexpected string value", expected.toString(), book.toString());
		
	}

}
