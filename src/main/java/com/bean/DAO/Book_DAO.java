package com.bean.DAO;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bean.Entity.BookDetails;

public interface Book_DAO {

	/* Book upload method */
	public String saveBook(BookDetails bookData, MultipartFile file) throws IOException;

	/* Get all the books */
	/* Here id is user's id .. which is used for showing books not owned by user */
	public List<BookDetails> getBooks(int id);

	public BookDetails getIndividualBook(int bookId);

	/* Get the epoch time */
	public String getEpochTime();

}