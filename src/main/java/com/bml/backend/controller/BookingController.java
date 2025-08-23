package com.bml.backend.controller;

import com.bml.backend.model.Booking;
import com.bml.backend.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public Booking createBooking(@RequestParam Long clientId,
                                 @RequestParam Long lawyerId,
                                 @RequestParam String date) {
        return bookingService.createBooking(clientId, lawyerId, LocalDate.parse(date));
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/client/{clientId}")
    public List<Booking> getBookingsByClient(@PathVariable Long clientId) {
        return bookingService.getBookingsByClientId(clientId);
    }

    @GetMapping("/lawyer/{lawyerId}")
    public List<Booking> getBookingsByLawyer(@PathVariable Long lawyerId) {
        return bookingService.getBookingsByLawyerId(lawyerId);
    }

    @PutMapping("/{bookingId}/status")
    public Booking updateBookingStatus(@PathVariable Long bookingId,
                                       @RequestParam String status) {
        return bookingService.updateBookingStatus(bookingId, status);
    }

    @PutMapping("/{bookingId}/cancel")
    public Booking cancelBooking(@PathVariable Long bookingId) {
        return bookingService.cancelBooking(bookingId);
    }
}
