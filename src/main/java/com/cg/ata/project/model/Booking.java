package com.cg.ata.project.model;


import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booking_table")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;

	@Column(name = "bookingDate")
	private LocalDate bookDate;

	@Column(name = "journeyDate")
	private LocalDate journeyDate;

	@Column(name = "boardingPoint")
	private String boardingPoint;

	@Column(name = "dropPoint")
	private String dropPoint;

	@Column(name = "source")
	private String source;

	@Column(name = "noOfPassenger")
	private int noOfPassenger;

//	@ManyToOne(cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "mobile", referencedColumnName = "mobile")
//	User user;
	
	@ManyToOne
	@JoinColumn(name = "vehId")
	private Vehicle vehicle ;

	public Booking() {
		super();
	}

	public Booking(int bookId, LocalDate bookDate, LocalDate journeyDate, String boardingPoint, String dropPoint,
			String source, int noOfPassenger, Vehicle vehicle) {
		super();
		this.bookId = bookId;
		this.bookDate = bookDate;
		this.journeyDate = journeyDate;
		this.boardingPoint = boardingPoint;
		this.dropPoint = dropPoint;
		this.source = source;
		this.noOfPassenger = noOfPassenger;
		this.vehicle = vehicle;
	}


	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public LocalDate getBookDate() {
		return bookDate;
	}

	public void setBookDate(LocalDate bookDate) {
		this.bookDate = bookDate;
	}

	public LocalDate getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}

	public String getBoardingPoint() {
		return boardingPoint;
	}

	public void setBoardingPoint(String boardingPoint) {
		this.boardingPoint = boardingPoint;
	}

	public String getDropPoint() {
		return dropPoint;
	}

	public void setDropPoint(String dropPoint) {
		this.dropPoint = dropPoint;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getNoOfPassenger() {
		return noOfPassenger;
	}

	public void setNoOfPassenger(int noOfPassenger) {
		this.noOfPassenger = noOfPassenger;
	}

//	public User getUser() {
//		return user;
//	}

//	public void setUser(User user) {
//		this.user = user;
//	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "Booking [bookId=" + bookId + ", bookDate=" + bookDate + ", journeyDate=" + journeyDate
				+ ", boardingPoint=" + boardingPoint + ", dropPoint=" + dropPoint + ", source=" + source
				+ ", noOfPassenger=" + noOfPassenger + ", vehicle=" + vehicle + "]";
	}

}
