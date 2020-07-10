package com.ysy.controller;

import com.ysy.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author shanyangyang
 * @date 2020/5/22
 */
@Controller
public class BookController {

	@Autowired
	private BookService bookService;
}
