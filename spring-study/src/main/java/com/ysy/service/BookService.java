package com.ysy.service;

import com.ysy.Dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author shanyangyang
 * @date 2020/5/22
 */
@Service
public class BookService {
	@Qualifier("bookDao")
	@Autowired
	private BookDao bookDao;
	public void print(){
		System.out.println(bookDao);
	}
}
