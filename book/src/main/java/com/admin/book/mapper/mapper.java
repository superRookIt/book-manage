package com.admin.book.mapper;

import java.util.Date;
import java.util.List;

import com.admin.book.Dto.Book;

public interface mapper {
	
	public void book_insert(String title, String writer, String company, Date open, String content);
	
	public List<Book> book_list();
	
}
