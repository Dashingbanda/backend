package com.bml.backend.service;

import com.bml.backend.exception.ResourceNotFoundException;
import com.bml.backend.model.Booking;
import com.bml.backend.model.Client;
import com.bml.backend.model.Lawyer;
import com.bml.backend.repository.BookingRepository;
import com.bml.backend.repository.ClientRepository;
import com.bml.backend.repository.LawyerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final LawyerRepository lawyerRepository;
    private final ClientRepository clientRepository;

    public BookingService(BookingRepository bookingRepository,
                          LawyerRepository lawyerRepository,
                          ClientRepository clientRepository) {
        this.bookingRepository = bookingRepository;
        this.lawyerRepository = lawyerRepository;
        this.clientRepository = clientRepository;
    }

    public Booking createBooking(Long clientId, Long lawyerId, LocalDate date) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id " + clientId));

        Lawyer lawyer = lawyerRepository.findById(lawyerId)
                .orElseThrow(() -> new ResourceNotFoundException("Lawyer not found with id " + lawyerId));

        // Check if lawyer already has a booking on that date
        boolean alreadyBooked = bookingRepository.existsByLawyerAndDate(lawyer, date);
        if (alreadyBooked) {
            throw new IllegalStateException("Lawyer is already booked on " + date);
        }

        Booking booking = new Booking();
        booking.setClient(client);
        booking.setLawyer(lawyer);
        booking.setDate(date);
        booking.setStatus("PENDING");

        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public List<Booking> getBookingsByClientId(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id " + clientId));
        return bookingRepository.findByClient(client);
    }

    public List<Booking> getBookingsByLawyerId(Long lawyerId) {
        Lawyer lawyer = lawyerRepository.findById(lawyerId)
                .orElseThrow(() -> new ResourceNotFoundException("Lawyer not found with id " + lawyerId));
        return bookingRepository.findByLawyer(lawyer);
    }

    public Booking updateBookingStatus(Long bookingId, String status) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id " + bookingId));

        booking.setStatus(status.toUpperCase());
        return bookingRepository.save(booking);
    }

    public Booking cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id " + bookingId));

        booking.setStatus("CANCELED");
        bookingRepository.save(booking);
        return booking;
    }

}
