package com.bean.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book_details")
public class BookDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotNull(message = "is required ")
	@Size(min = 3, message = "Your book name must be 3 characters long")
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "Please enter valid book name")
	@Column(name = "book_name")
	private String bookName;

	@NotNull(message = "is required ")
	@Size(min = 3, message = "Your book author name must be 3 characters long")
	@Pattern(regexp = "^[a-zA-Z ]*$", message = "Please enter valid book author name")
	@Column(name = "book_author")
	private String bookAuthor;

	@NotNull(message = "is required ")
	@Pattern(regexp = "^[0-9]*$", message = "Subject code must be in digits only")
	@Column(name = "subject_code")
	private String subjectCode;

	@NotNull(message = "is required ")
	@Column(name = "branch_name")
	private String branch;

	@NotNull(message = "is required ")
	@Column(name = "semester")
	private String semester;

	@NotNull(message = "is required ")
	@Column(name = "book_edition")
	private String bookEdition;

	@NotNull(message = "is required")
	@Column(name = "uploader_id")
	private int uploaderId;

//	@NotNull(message = "is required")
//	@Column(name = "book_data")
//	private byte[] data;

	private String imageName;

	@NotNull(message = "is required")
	@Column(name = "book_availability")
	private int availability = 1;

	public BookDetails() {

	}

	public BookDetails(String bookName, String bookAuthor, String subjectCode, String branch, String semester,
			String bookEdition, int uploaderId, String imageName, int availability) {
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.subjectCode = subjectCode;
		this.branch = branch;
		this.semester = semester;
		this.bookEdition = bookEdition;
		this.uploaderId = uploaderId;
		this.imageName = imageName;
		this.availability = availability;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

//	public byte[] getData() {
//		return data;
//	}
//
//	public void setData(byte[] data) {
//		this.data = data;
//	}

	public int getId() {
		return id;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getBookEdition() {
		return bookEdition;
	}

	public void setBookEdition(String bookEdition) {
		this.bookEdition = bookEdition;
	}

	public int getUploaderId() {
		return uploaderId;
	}

	public void setUploaderId(int uploaderId) {
		this.uploaderId = uploaderId;
	}

	@Override
	public String toString() {
		return "BookDetails [id=" + id + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", subjectCode="
				+ subjectCode + ", branch=" + branch + ", semester=" + semester + ", bookEdition=" + bookEdition
				+ ", uploaderId=" + uploaderId + ", imageName=" + imageName + ", availability=" + availability + "]";
	}

}
