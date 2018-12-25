package com.project.hotelreservation.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "guest")
public class Guest {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@NotEmpty
	@Size(min=3,max=30,  message ="First Name Propertiy must be more than or equals 3 and less than or eqals 30 " )
	private String fname;
	@NotEmpty
	@Size(min=3,max=30,  message ="Last Name Propertiy must be more than or equals 3 and less than 30 " )
	private String lname;
	@NotEmpty
	@Email(message = "Email must be required")
	private String email;
	@NotEmpty
	@Size(min=8,max=12, message = "Phone Number Propertiy must be more than or equals 8 and less than 10")
	private String phone;

	public Guest() {
	}

	public Guest(String fname, String lname, String email, String phone) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}


