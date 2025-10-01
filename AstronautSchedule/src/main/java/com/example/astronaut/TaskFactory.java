package com.example.astronaut;

public class TaskFactory {

    // Factory method to create a new Task
    public Task createTask(String description, String startTime, String endTime, String priority) {
        // Validate inputs (optional: you can add more validation later)
        if(description == null || description.isEmpty()) {
            System.out.println("Error: Description cannot be empty.");
            return null;
        }
        if(!isValidTime(startTime) || !isValidTime(endTime)) {
            System.out.println("Error: Invalid time format.");
            return null;
        }

        // Default priority if invalid
        if(priority == null || priority.isEmpty()) {
            priority = "Medium";
        }

        return new Task(description, startTime, endTime, priority);
    }

    // Simple time format validation (HH:mm)
    private boolean isValidTime(String time) {
        if(time == null) return false;
        return time.matches("([01]\\d|2[0-3]):([0-5]\\d)");
    }
}
