package com.admin.book.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.book.Dto.Book;
import com.admin.book.mapper.mapper;

@Service
public class BServiceImpl implements BService {

	@Autowired
	mapper mapper;

	@Override
	public void book_insert(String title, String writer, String company, Date open, String content) {
		mapper.book_insert(title, writer, company, open, content);
	}

	@Override
	public List<Book> book_list() {
		return mapper.book_list();
	}

	@Override
	public void url_update(String url, String title) {
		mapper.url_update(url, title);
	}
	

}
