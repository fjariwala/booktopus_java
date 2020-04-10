package com.bean.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_details")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@NotNull(message = "is required ")
	@Size(min = 2, message = "Your first name must be two characters long")
	@Pattern(regexp = "^[A-Za-z]+$", message = "Please enter valid first name")
	@Column(name = "first_name")
	private String firstName;

	@NotNull(message = "is required ")
	@Size(min = 2, message = "Your first name must be two characters long")
	@Pattern(regexp = "^[A-Za-z]+$", message = "Please enter valid last name")
	@Column(name = "last_name")
	private String lastName;

	@NotNull(message = "is required")
	@Size(min = 1, message = "Please enter email")
	@Email(message = "Please enter valid email address")
	@Column(name = "email")
	private String email;

	@NotNull(message = "is required")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,8}$", message = "Your password must has one uppercase, lowercase, digit, a special character and it must be 8 characters long")
	@Column(name = "password")
	private String password;

	@NotNull(message = "is required")
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Your contact number should be 10 digits long")
	@Column(name = "phone_no")
	private String phone;

	/* Default constructor */
	public UserDetails() {

	}

	/* Parameterized constructor */

	public UserDetails(String firstName, String lastName, String email, String password, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	/* Getters and Setters */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", phone=" + phone + "]";
	}

}
