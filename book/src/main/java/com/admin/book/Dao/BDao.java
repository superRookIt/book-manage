package com.admin.book.Dao;

import java.util.Date;

import com.admin.book.Dto.Book;

public interface BDao {
	
	public void book_insert(String title, String writer, String company, Date open, String content);
	
	public Book book_list();
	
}
