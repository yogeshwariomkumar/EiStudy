package com.example.astronaut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScheduleManager {

    // Singleton instance
    private static ScheduleManager instance;

    // List of tasks
    private List<Task> tasks;

    // Private constructor to prevent instantiation
    private ScheduleManager() {
        tasks = new ArrayList<>();
    }

    // Method to get the single instance
    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    // Add a task
    public boolean addTask(Task task) {
        // Check for overlapping tasks
        for(Task t : tasks) {
            if(isOverlapping(task, t)) {
                System.out.println("Error: Task conflicts with existing task \"" + t.getDescription() + "\".");
                return false;
            }
        }
        tasks.add(task);
        System.out.println("Task added successfully. No conflicts.");
        return true;
    }

    // Remove a task by description
    public boolean removeTask(String description) {
        for(Task t : tasks) {
            if(t.getDescription().equalsIgnoreCase(description)) {
                tasks.remove(t);
                System.out.println("Task removed successfully.");
                return true;
            }
        }
        System.out.println("Error: Task not found.");
        return false;
    }

    // View all tasks sorted by start time
    public void viewTasks() {
        if(tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            return;
        }
        // Sort tasks by start time
        Collections.sort(tasks, Comparator.comparing(Task::getStartTime));
        for(Task t : tasks) {
            System.out.println(t);
        }
    }

    // Check if two tasks overlap
    private boolean isOverlapping(Task t1, Task t2) {
        return !(t1.getEndTime().compareTo(t2.getStartTime()) <= 0 || t1.getStartTime().compareTo(t2.getEndTime()) >= 0);
    }
}
