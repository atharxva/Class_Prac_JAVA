import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task {
    String task_name;
    boolean status;
    boolean marked_later;
    List<String> task_list;

    public Task() {
        task_list = new ArrayList<>();
    }

    public void listTasks() {
        if (task_list.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (int i = 0; i < task_list.size(); i++) {
                System.out.println((i + 1) + ". " + task_list.get(i));
            }
        }
    }

    public void addTask() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter the name of the task");
            task_name = input.nextLine();
            System.out.println("Enter the status of the task (True/False)");
            status = input.nextBoolean();
            System.out.println("Is it marked later (True/False)");
            marked_later = input.nextBoolean();
            task_list.add(task_name);
            System.out.println("The task was added successfully");
        }
    }

    public void displayTasksByStatus(boolean status) {
        boolean found = false;
        for (String task : task_list) {
            if (this.status == status) {
                System.out.println(task);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No tasks found with the given status.");
        }
    }

    public void deleteTask(int index) {
        if (index >= 1 && index <= task_list.size()) {
            task_list.remove(index - 1);
            System.out.println("Task deleted successfully");
        } else {
            System.out.println("Invalid task index");
        }
    }

    public static void main(String[] args) {
        Task taskManager = new Task();
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Display Tasks by Status");
            System.out.println("4. Delete Task");
            System.out.println("0. Exit");
            System.out.println("Enter your choice:");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    taskManager.addTask();
                    break;
                case 2:
                    taskManager.listTasks();
                    break;
                case 3:
                    System.out.println("Enter the status (True/False):");
                    boolean status = input.nextBoolean();
                    taskManager.displayTasksByStatus(status);
                    break;
                case 4:
                    System.out.println("Enter the index of the task to delete:");
                    int index = input.nextInt();
                    taskManager.deleteTask(index);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 0);

        input.close();
    }
}
