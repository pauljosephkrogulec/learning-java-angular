package com.learning.tasktracker.scratch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskConsoleApp {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int ids = 0;
        outer:
        while (true) {
            String line = scanner.nextLine();          // lit une ligne tapée par l'utilisateur
            String[] parts = line.split(" ", 2);        // sépare en 2 : la commande, et le reste
            String command = parts[0];

            switch (command) {
                case "quit":
                    break outer;                         // sort de la boucle while
                case "add":
                    if (parts.length >= 2) {
                        String title = parts[1];
                        tasks.add(new Task(ids++, title));
                    }
                    break;
                case "list":
                    for (Task task : tasks) {
                        System.out.println(task.getId() + ". " + task);
                    }
                    break;
                case "done":
                    if (parts.length >= 2) {
                        int id = Integer.parseInt(parts[1]);
                        for (Task task : tasks) {
                            if (task.getId() == id) {
                                task.setDone(true);
                                break;
                            }
                        }
                    }
                    break;
                case "remove":
                    if (parts.length >= 2) {
                        int removeId = Integer.parseInt(parts[1]);
                        tasks.removeIf(task -> task.getId() == removeId);
                    }
                    break;
                default:
                    System.out.println("Commande inconnue: " + command);
            }
        }

        scanner.close();
    }
}