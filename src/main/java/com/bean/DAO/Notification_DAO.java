package com.bean.DAO;

import java.util.List;

import com.bean.Entity.NotificationClass;

public interface Notification_DAO {

	/* To set accept and reject the book request method */
	public NotificationClass getIndividualNotificationForAcceptAndReject(int notificationId, Boolean acceptReq,
			Boolean rejectReq);

	/* This method will be used to get all the notifications */
	public List<NotificationClass> getAllNotifications();

	/* To show the current requests for the user */
	public List<NotificationClass> getNotificationForUser(int userId);

	/* To show which requests the user had made */
	public List<NotificationClass> getNotificationMadeByTheUser(int userId);

	/* Cancel book using notification id .. Okay?? */
	public Boolean toCancelTheNotification(int notificationId);

	/* To get an individual notification by it's id */
	// public NotificationClass getIndividualNotificationByItsId(int
	// notificationId);

}
