package com.cia2.campusbooking.model;

public class Booking {

    private Long id;
    private Long equipmentId;
    private String borrowerName;

    public Booking() {
    }

    public Booking(Long id, Long equipmentId, String borrowerName) {
        this.id = id;
        this.equipmentId = equipmentId;
        this.borrowerName = borrowerName;
    }

    public Long getId() {
        return id;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public String getBorrowerName() {
        return borrowerName;
    }
}