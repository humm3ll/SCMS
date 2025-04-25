// Resource.java
// Written by Filipe Ramos
// Last edited: 23rd April 2025
// Class to manage resources like library books

import java.util.HashMap;

public class Resource {
    private String title; // Resource title
    private boolean isAvailable; // Availability status

    // Static map to track resources
    private static HashMap<String, Resource> resourceMap = new HashMap<>();

    // Constructor
    public Resource(String title) {
        this.title = title;
        this.isAvailable = true; // Initially available
        resourceMap.put(title, this); // Add resource to the map
    }

    // Method to borrow a resource
    public String borrowResource() {
        if (isAvailable) {
            isAvailable = false; // Set resource as borrowed
            return "Resource borrowed successfully."; // Success message
        }
        return "Resource is not available."; // Error message
    }

    // Method to return a resource
    public String returnResource() {
        if (!isAvailable) {
            isAvailable = true; // Set resource as available
            return "Resource returned successfully."; // Success message
        }
        return "Resource was not borrowed."; // Error message
    }

    // Method to check resource status
    public String getResourceStatus() {
        return isAvailable ? "Resource is available." : "Resource is borrowed.";
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}