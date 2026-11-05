package com.cia2.campusbooking.controller;

import com.cia2.campusbooking.model.Equipment;
import com.cia2.campusbooking.service.BookingService;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {

    private final BookingService service;

    public EquipmentController(BookingService service) {
        this.service = service;
    }

    @GetMapping
    public Collection<Equipment> getAllEquipment() {
        return service.getAllEquipment();
    }

    @GetMapping("/{id}")
    public Equipment getEquipment(@PathVariable Long id) {
        return service.getEquipmentById(id);
    }

    @PostMapping
    public Equipment addEquipment(@RequestBody Equipment equipment) {
        return service.addEquipment(equipment);
    }
}