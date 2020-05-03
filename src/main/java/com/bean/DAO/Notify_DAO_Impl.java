package com.bean.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Entity.BookDetails;
import com.bean.Entity.NotificationClass;

/*
 * This annotation automatically registers our DAO class into the dispatcher-servlet.xml file
 * This work of automatically registration is done by Spring in the back-end
 * */
@Repository
public class Notify_DAO_Impl implements Notification_DAO {

	/* Need to inject the session factory from dispatcher-servlet to file here */
	/*
	 * We write 'Autowired' just to connect our sessionFactory object from This
	 * class to the dispatcher-servlet's step 2's id object
	 */
	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private Book_DAO bookDao;

	/*
	 * @Transactional => This annotation is used for : When we use this annotation
	 * it automatically begins the transaction and it automatically commits the
	 * transaction
	 */
	@Transactional
	public List<NotificationClass> getAllNotifications() {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();

		String que = "from NotificationClass";
		Query<NotificationClass> query = session.createQuery(que, NotificationClass.class);
		List<NotificationClass> resultNotify = query.getResultList();

		return resultNotify;
	}

	@Transactional
	public List<NotificationClass> getNotificationForUser(int userId) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();
		String que = "from NotificationClass n where n.uploaded_by_id=" + userId;

		Query<NotificationClass> query = session.createQuery(que, NotificationClass.class);
		List<NotificationClass> allTheNotificationsForUser = query.getResultList();

		return allTheNotificationsForUser;
	}

	@Transactional
	public List<NotificationClass> getNotificationMadeByTheUser(int userId) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();

		String que = "from NotificationClass n where n.requested_by_id=" + userId
				+ " order by n.current_status asc 	";

		Query<NotificationClass> query = session.createQuery(que, NotificationClass.class);
		List<NotificationClass> allTheNotificationsMadeByCurrentUser = query.getResultList();

		return allTheNotificationsMadeByCurrentUser;
	}

	@Transactional
	public NotificationClass getIndividualNotificationForAcceptAndReject(int notificationId, Boolean acceptReq,
			Boolean rejectReq) {
		// TODO Auto-generated method stub

		NotificationClass returnStmt = null;

		Session session = sessionFactory.getCurrentSession();

		String que = "from NotificationClass n where n.id=" + notificationId + "	";
		Query<NotificationClass> query = session.createQuery(que, NotificationClass.class);
		NotificationClass notificationData = query.uniqueResult();

		/* Accept */
		if (acceptReq == true && rejectReq == false) {

			notificationData.setCurrent_status(-1);

			BookDetails bookData = bookDao.getIndividualBook(notificationData.getRequested_book_id());

			bookData.setAvailability(-1);

			session.saveOrUpdate(notificationData);
			session.saveOrUpdate(bookData);

			returnStmt = notificationData;
		}

		/* Reject */
		if (acceptReq == false && rejectReq == true) {

			notificationData.setCurrent_status(1);

			BookDetails bookData = bookDao.getIndividualBook(notificationData.getRequested_book_id());

			bookData.setAvailability(1);

			session.saveOrUpdate(notificationData);
			session.saveOrUpdate(bookData);

			returnStmt = notificationData;
		}

		return returnStmt;
	}

}
