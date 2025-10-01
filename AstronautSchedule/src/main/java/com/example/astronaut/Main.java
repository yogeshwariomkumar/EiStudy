package com.example.astronaut;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ScheduleManager manager = ScheduleManager.getInstance(); // Singleton instance
        TaskFactory factory = new TaskFactory();
        TaskObserver observer = new TaskObserver("Astronaut"); // Observer for notifications

        while (true) {
            System.out.println("\n--- Astronaut Daily Schedule Organizer ---");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Description: ");
                    String desc = sc.nextLine();

                    System.out.print("Enter Start Time (HH:mm): ");
                    String start = sc.nextLine();

                    System.out.print("Enter End Time (HH:mm): ");
                    String end = sc.nextLine();

                    System.out.print("Enter Priority (High/Medium/Low): ");
                    String priority = sc.nextLine();

                    Task task = factory.createTask(desc, start, end, priority);
                    if(task != null) {
                        boolean added = manager.addTask(task);
                        if(added) observer.update("Task added: " + desc);
                    }
                    break;

                case "2":
                    System.out.print("Enter Task Description to Remove: ");
                    String removeDesc = sc.nextLine();
                    boolean removed = manager.removeTask(removeDesc);
                    if(removed) observer.update("Task removed: " + removeDesc);
                    break;

                case "3":
                    manager.viewTasks();
                    break;

                case "4":
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
