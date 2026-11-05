package com.cia2.campusbooking.controller;

import com.cia2.campusbooking.model.Booking;
import com.cia2.campusbooking.service.BookingService;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public Booking bookEquipment(@RequestBody Map<String, String> request) {

        Long equipmentId = Long.parseLong(request.get("equipmentId"));

        String borrowerName = request.get("borrowerName");

        return service.bookEquipment(equipmentId, borrowerName);
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return service.getAllBookings();
    }
}