package com.bean.DAO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.bean.Entity.BookDetails;
import com.bean.Entity.NotificationClass;
import com.bean.Entity.UserDetails;

/*
 * This annotation automatically registers our DAO class into the dispatcher-servlet.xml file
 * This work of automatically registration is done by Spring in the back-end
 * */
@Repository
public class Book_DAO_Impl implements Book_DAO {

	/* Need to inject the session factory from dispatcher-servlet to file here */
	/*
	 * We write 'Autowired' just to connect our sessionFactory object from This
	 * class to the dispatcher-servlet's step 2's id object
	 */
	@Autowired
	private SessionFactory sessionFactory;
	private Boolean returnValue;

	/*
	 * @Transactional => This annotation is used for : When we use this annotation
	 * it automatically begins the transaction and it automatically commits the
	 * transaction
	 */
	@Transactional
	public String saveBook(BookDetails bookData, MultipartFile file) throws IOException {
		// TODO Auto-generated method stub

		/* Here we store our image into the file system */
		String folder = "E:/Elcipse Resource/Booktopus/src/main/webapp/resources/uploads/";
		byte[] byteData = file.getBytes();

		/* Renaming the file */
		String newFileName = StringUtils.cleanPath(file.getOriginalFilename());
		newFileName = getEpochTime() + "_" + newFileName.toLowerCase().replaceAll(" ", "-");
		System.out.println(newFileName);

		Path path = Paths.get(folder + newFileName);

		/* Saving into the database */
		Session session = sessionFactory.getCurrentSession();

		try {

			bookData.setImageName(newFileName);

			session.save(bookData);
			Files.write(path, byteData);

			return "Success";

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Transactional
	public List<BookDetails> getBooks(int userId) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();

		try {

			String que = "from BookDetails s where s.availability=1 AND s.uploaderId!=" + userId + "	";

			Query<BookDetails> books = session.createQuery(que, BookDetails.class);
			List<BookDetails> storedBooks = books.getResultList();

//			for (BookDetails bookDetails : storedBooks) {
//				System.out.println(bookDetails);
//			}

			return storedBooks;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage() + e.getCause());
			return null;
		}
	}

	public String getEpochTime() {
		// TODO Auto-generated method stub

		Date today = Calendar.getInstance().getTime();

		// Constructs a SimpleDateFormat using the given pattern
		SimpleDateFormat crunchifyFormat = new SimpleDateFormat("MMM dd yyyy HH:mm:ss.SSS zzz");

		// format() formats a Date into a date/time string.
		String currentTime = crunchifyFormat.format(today);

		try {

			// parse() parses text from the beginning of the given string to produce a date.
			Date date = crunchifyFormat.parse(currentTime);

			// getTime() returns the number of milliseconds since January 1, 1970, 00:00:00
			// GMT represented by this Date object.
			long epochTime = date.getTime();
			epochTime = epochTime / 1000;
			String currTime = Long.toString(epochTime);
			return currTime;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return "null";
		}

	}

	@Transactional
	public BookDetails getIndividualBook(int bookId) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();

		try {

			BookDetails bookData = session.get(BookDetails.class, bookId);

			return bookData;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Transactional
	public List<BookDetails> searchBooks(String regexPattern, int userId) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();

		String query = "from BookDetails b where b.bookName LIKE:testVar	";
		Query<BookDetails> que = session.createQuery(query, BookDetails.class);
		que.setParameter("testVar", "%" + regexPattern + "%");

		/* Here all the books are stored */
		List<BookDetails> newData = que.getResultList();

		/* In this list we save that books only which are not uploaded by user */
		List<BookDetails> sortedData = new ArrayList<BookDetails>();

		/*
		 * Here uplaoder id != userId means , We will not show any books which are
		 * uploaded by logged in user, We will just show that books which are not
		 * uploaded by logged in user
		 */
		for (BookDetails bookDetails : newData) {

			if (bookDetails.getUploaderId() != userId) {
				sortedData.add(bookDetails);
			}
		}

		return sortedData;

	}

	@Transactional
	public Boolean setNotification(BookDetails bookData, UserDetails userData,
			List<NotificationClass> notificationData) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();

		Boolean returnValue = null;

		int length = notificationData.size();
		System.out.println(length);

		/* If the table is empty then directly add notification to the table */
		if (notificationData.isEmpty()) {

			NotificationClass notify = new NotificationClass();

			/*
			 * 0 -> for pending ...... 1-> for accepted ...... -1 -> for rejected
			 */
			notify.setCurrent_status(0);

			/* Which book is requested ? */
			notify.setRequested_book_id(bookData.getId());

			/* Name of the book which is requested? */
			notify.setRequested_book_name(bookData.getBookName());

			/* Which user requested the book ? */
			notify.setRequested_by_id(userData.getId());

			/* User names ? */
			notify.setRequested_by_name(userData.getFirstName() + " " + userData.getLastName());

			/* Uploaded by which user ? */
			notify.setUploaded_by_id(bookData.getUploaderId());

			session.saveOrUpdate(notify);

			/* Here we decrease the availability of book from 1 -> 0 */
			bookData.setAvailability(0);

			session.saveOrUpdate(bookData);

			return true;

		}

		/* If there is only one notification in the table */
		if (notificationData.size() == 1) {

			NotificationClass notifyOneNotification = notificationData.get(0);
			System.out.println(notifyOneNotification.getRequested_book_name());

			if (notifyOneNotification.getRequested_book_id() == bookData.getId()) {

				return false;

			} else {

				NotificationClass notify = new NotificationClass();

				/*
				 * 0 -> for pending ...... 1-> for accepted ...... -1 -> for rejected
				 */
				notify.setCurrent_status(0);

				/* Which book is requested ? */
				notify.setRequested_book_id(bookData.getId());

				/* Name of the book which is requested? */
				notify.setRequested_book_name(bookData.getBookName());

				/* Which user requested the book ? */
				notify.setRequested_by_id(userData.getId());

				/* User names ? */
				notify.setRequested_by_name(userData.getFirstName() + " " + userData.getLastName());

				/* Uploaded by which user ? */
				notify.setUploaded_by_id(bookData.getUploaderId());

				session.saveOrUpdate(notify);

				/* Here we decrease the availability of book from 1 -> 0 */
				bookData.setAvailability(0);

				session.saveOrUpdate(bookData);

				return true;

			}
		}

		/* 0 -> Means the notification doesn't exists */
		int isNotificationExists = 0;
		/* If the list size is more than 1 */
		/* True -> Notification set ..... False -> No access .. Already exists */
		for (NotificationClass notifyObj : notificationData) {

			if (notifyObj.getRequested_book_id() == bookData.getId()) {
				/* 1 -> means that the notification already exists */
				isNotificationExists = 1;
				return false;
				// return false;
			}
		}

		// System.out.println(isNotificationExists);
		/* We will go into this .. if the notification doesn't exists */
		if (isNotificationExists != 1) {

			System.out.println("into multiple onme");

			NotificationClass notify = new NotificationClass();

			/*
			 * 0 -> for pending ...... 1-> for accepted ...... -1 -> for rejected
			 */
			notify.setCurrent_status(0);

			/* Which book is requested ? */
			notify.setRequested_book_id(bookData.getId());

			/* Name of the book which is requested? */
			notify.setRequested_book_name(bookData.getBookName());

			/* Which user requested the book ? */
			notify.setRequested_by_id(userData.getId());

			/* User names ? */
			notify.setRequested_by_name(userData.getFirstName() + " " + userData.getLastName());

			/* Uploaded by which user ? */
			notify.setUploaded_by_id(bookData.getUploaderId());

			session.saveOrUpdate(notify);

			/* Here we decrease the availability of book from 1 -> 0 */
			bookData.setAvailability(0);

			session.saveOrUpdate(bookData);

			return true;
		}

		return true;
	}

	@Transactional
	public List<NotificationClass> getAllNotifications() {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();

		String query = "from NotificationClass";
		Query<NotificationClass> que = session.createQuery(query, NotificationClass.class);
		List<NotificationClass> resultedNotifications = que.getResultList();

		return resultedNotifications;
	}

}
