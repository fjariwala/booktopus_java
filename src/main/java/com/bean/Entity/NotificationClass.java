package com.bean.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notification_table")
public class NotificationClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "uploaded_by_id")
	private int uploaded_by_id;

	@Column(name = "req_book_id")
	private int requested_book_id;

	@Column(name = "req_book_name")
	private String requested_book_name;

	@Column(name = "req_by_id")
	private int requested_by_id;

	@Column(name = "req_user_name")
	private String requested_by_name;

	@Column(name = "curr_status")
	private int current_status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUploaded_by_id() {
		return uploaded_by_id;
	}

	public void setUploaded_by_id(int uploaded_by_id) {
		this.uploaded_by_id = uploaded_by_id;
	}

	public String getRequested_book_name() {
		return requested_book_name;
	}

	public void setRequested_book_name(String requested_book_name) {
		this.requested_book_name = requested_book_name;
	}

	public int getRequested_book_id() {
		return requested_book_id;
	}

	public void setRequested_book_id(int requested_book_id) {
		this.requested_book_id = requested_book_id;
	}

	public int getRequested_by_id() {
		return requested_by_id;
	}

	public void setRequested_by_id(int requested_by_id) {
		this.requested_by_id = requested_by_id;
	}

	public String getRequested_by_name() {
		return requested_by_name;
	}

	public void setRequested_by_name(String requested_by_name) {
		this.requested_by_name = requested_by_name;
	}

	public int getCurrent_status() {
		return current_status;
	}

	public void setCurrent_status(int current_status) {
		this.current_status = current_status;
	}

}
