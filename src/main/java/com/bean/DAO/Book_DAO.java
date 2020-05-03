package com.bean.DAO;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bean.Entity.BookDetails;
import com.bean.Entity.NotificationClass;
import com.bean.Entity.UserDetails;

public interface Book_DAO {

	/* Book upload method */
	public String saveBook(BookDetails bookData, MultipartFile file) throws IOException;

	/* Get all the books */
	/* Here id is user's id .. which is used for showing books not owned by user */
	public List<BookDetails> getBooks(int userId);

	/* Get an individual book by book id */
	public BookDetails getIndividualBook(int bookId);

	/* Search Book */
	public List<BookDetails> searchBooks(String regexPattern, int userId);

	/* To set the notification of book */
	public Boolean setNotification(BookDetails bookData, UserDetails userData,
			List<NotificationClass> notificationData);

	/*
	 * This method will be used to check weather the request is already made or
	 * not... If the request is already made then the error message will be shown
	 */
	public List<NotificationClass> getAllNotifications();

	/* Get the epoch time */
	public String getEpochTime();

}
