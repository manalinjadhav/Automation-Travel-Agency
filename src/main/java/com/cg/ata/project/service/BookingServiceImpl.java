package com.cg.ata.project.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ata.project.exception.BookingNotFoundException;
import com.cg.ata.project.exception.DriverAlreadyExistsException;
import com.cg.ata.project.model.Booking;

import com.cg.ata.project.repository.BookingRepository;


@Service
public class BookingServiceImpl implements IBookingService {

	@Autowired
	BookingRepository bookRepository;

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<Booking> viewAllBooking() {
		return bookRepository.findAll();
	}
	
	@Override
	public Booking viewBookingById(int bookingId) {
		Optional<Booking> bokOptional = bookRepository.findById(bookingId);
		Booking booking = null;
		if (bokOptional.isPresent()) {
			booking = bokOptional.get();
			LOG.info(booking.toString());
			return booking;
		} else {
			String errorMessage = "Booking with booking " + bookingId + " does not exist.";
			LOG.error(errorMessage);
			throw new BookingNotFoundException("Booking not found");
		}
	}

//	public Booking addBooking(Booking booking) {
//	Optional<Booking> bokOptional = bookRepository.findById(booking.getBookId());
//	if (bokOptional != null) {
//		String exceptionMessage = "Booking already exist in the database.";
//		LOG.warn(exceptionMessage);
//		throw new BookingAlreadyExistsException("Booking Already Exit");
//	} else {
//		LOG.info("List returned successfully.");
//		return bookRepository.save(booking);
//	}
//
//}
	@Override
	public Booking addBooking(Booking booking) {
		LOG.info(booking.toString());
		Optional<Booking> bokOptional = bookRepository.findById(booking.getBookId());
		if (bokOptional != null) {
			return bookRepository.save(booking);
		} else {
			String exceptionMessage = "Booking already exist in the database.";
			LOG.info(exceptionMessage);
			throw new DriverAlreadyExistsException("Driver Already Exist");
		}
	}

	@Override
	public Booking modifyBooking(Booking booking) {
		LOG.info(booking.toString());
		this.viewBookingById(booking.getBookId());
		return bookRepository.save(booking);
	}

	@Override
	public Booking cancelBooking(int bookingId) {
		LOG.info(Integer.toString(bookingId));
		Booking bokToDelete = this.viewBookingById(bookingId);
		if(bokToDelete != null) {
		bookRepository.delete(bokToDelete);
		return bokToDelete;
	}
	else {
			throw new BookingNotFoundException("Booking not found"); 
		}
	}

}


