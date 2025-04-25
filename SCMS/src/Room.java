// Room.java
// Written by Harvey Lacey
// Last edited: 23rd April 2025
// Class to manage room bookings

import java.util.HashMap;

public class Room {
    private String roomNumber; // Room number
    private boolean isBooked; // Booking status

    // Static map to track room bookings
    private static HashMap<String, Room> roomMap = new HashMap<>();

    // Constructor
    public Room(String roomNumber) {
        this.roomNumber = roomNumber;
        this.isBooked = false; // Initially not booked
        roomMap.put(roomNumber, this); // Add room to the map
    }

    // Method to book a room
    public String bookRoom() {
        if (!isBooked) {
            isBooked = true; // Set room as booked
            return "Room booked successfully."; // Success message
        }
        return "Room is already booked."; // Error message
    }

    // Method to release a room
    public String releaseRoom() {
        if (isBooked) {
            isBooked = false; // Set room as not booked
            return "Room released successfully."; // Success message
        }
        return "Room is not booked."; // Error message
    }

    // Method to check room status
    public String getRoomStatus() {
        return isBooked ? "Room is booked." : "Room is available.";
    }

    // Getters
    public String getRoomNumber() {
        return roomNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }
}