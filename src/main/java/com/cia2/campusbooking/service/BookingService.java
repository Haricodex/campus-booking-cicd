package com.cia2.campusbooking.service;

import com.cia2.campusbooking.model.Equipment;
import com.cia2.campusbooking.model.Booking;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookingService {

    private final Map<Long, Equipment> equipment = new HashMap<>();
    private final List<Booking> bookings = new ArrayList<>();

    private final AtomicLong equipmentId = new AtomicLong(1);
    private final AtomicLong bookingId = new AtomicLong(1);

    public BookingService() {
        addEquipment(new Equipment(null, "Laptop", "Electronics", true));
        addEquipment(new Equipment(null, "Projector", "Electronics", true));
        addEquipment(new Equipment(null, "Camera", "Photography", true));
    }

    public Equipment addEquipment(Equipment item) {

        Long id = equipmentId.getAndIncrement();

        item.setId(id);
        item.setAvailable(true);

        equipment.put(id, item);

        return item;
    }

    public Collection<Equipment> getAllEquipment() {
        return equipment.values();
    }

    public Equipment getEquipmentById(Long id) {

        Equipment item = equipment.get(id);

        if (item == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Equipment not found"
            );
        }

        return item;
    }

    public Booking bookEquipment(Long id, String borrowerName) {

        Equipment item = getEquipmentById(id);

        if (!item.isAvailable()) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT, "Equipment already booked"
            );
        }

        item.setAvailable(false);

        Booking booking = new Booking(
            bookingId.getAndIncrement(),
            id,
            borrowerName
        );

        bookings.add(booking);

        return booking;
    }

    public List<Booking> getAllBookings() {
        return bookings;
    }
}