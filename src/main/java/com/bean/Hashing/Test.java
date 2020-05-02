package com.bean.Hashing;

import java.util.List;

import com.bean.DAO.Book_DAO;
import com.bean.DAO.Book_DAO_Impl;
import com.bean.Entity.BookDetails;

public class Test {

	public static void main(String[] args) {

		Book_DAO bookDao = new Book_DAO_Impl();

		// List<BookDetails> data = bookDao.getBooks();
		List<BookDetails> list = bookDao.searchBooks("advanced", 1);

		for (BookDetails bookDetails : list) {
			System.out.println(bookDetails);
		}
	}
}
