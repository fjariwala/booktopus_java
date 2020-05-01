package com.bean.DAO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
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
	public List<BookDetails> getBooks(int id) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();

		try {

			String que = "from BookDetails s where s.availability=1 AND s.uploaderId!=" + id + "	";

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

}
