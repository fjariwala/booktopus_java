package com.bean.DAO;

import java.util.List;

import com.bean.Entity.NotificationClass;

public interface Notification_DAO {

	/* This method will be used to get all the notifications */
	public List<NotificationClass> getAllNotifications();

	/* Get notification for the specific user by it's userId */
	public List<NotificationClass> getNotificationForUser(int userId);

}
