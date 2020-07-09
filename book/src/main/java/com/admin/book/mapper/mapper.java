package com.admin.book.mapper;

import java.util.Date;
import java.util.List;

import com.admin.book.Dto.Book;

public interface mapper {
	
	public void book_insert(String title, String writer, String company, Date open, String content);
	
	public void url_update(String url, String title);
	
	public List<Book> book_list();
	
	
}
