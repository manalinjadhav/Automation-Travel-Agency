package com.cg.ata.project.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.ata.project.model.Booking;
import com.cg.ata.project.service.BookingServiceImpl;

@RestController
//@RequestMapping("/book")
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class BookingController {

	@Autowired
	private BookingServiceImpl bookService;

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	/***********************view booking by id*****************************/
	
	@GetMapping("/view-book-by-id/{bookingID}")
	public ResponseEntity<Booking> getBookById(@PathVariable(name = "bookingID") int bookingID) {
		LOG.info(Integer.toString(bookingID));
		Booking book = bookService.viewBookingById(bookingID);
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<Booking> response = new ResponseEntity<>(book, status);
		return response;
	}
    
	/***********************book vehicle**************************************/
	
	@PostMapping("/book-vehicle")
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
		LOG.info(booking.toString());
		HttpStatus status = HttpStatus.CREATED;
		ResponseEntity<Booking> response = new ResponseEntity<>(bookService.addBooking(booking), status);
		return response;
	} 
	
	/******************booking status****************************/
	
//	@GetMapping("/view-booking")
//	public ResponseEntity<List<Booking>> viewAllbooks() {
//		List<Booking> bookingList = bookService.viewAllBooking();
//		for (Booking bookTemp : bookingList)
//			LOG.info(bookTemp.toString());
//		HttpStatus status = HttpStatus.OK;
//		ResponseEntity<List<Booking>> response = new ResponseEntity<>(bookingList, status);
//		return response;
//	}

	/******************cancel booking******************/
	
	@DeleteMapping("/cancel-booking/{bookingId}")
	public ResponseEntity<Booking> cancelBooking(@PathVariable(name = "bookingId") int bookingId) {
		LOG.info(Integer.toString(bookingId));
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<Booking> response = new ResponseEntity<>(bookService.cancelBooking(bookingId), status);
		return response;
	}

}

