
class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "[" + taskId + " - " + taskName + " - " + status + "]";
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskManagementSystem {
    private Node head;

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null)
            current = current.next;
        current.next = newNode;
    }

    public Task searchTask(int id) {
        Node current = head;
        while (current != null) {
            if (current.task.taskId == id)
                return current.task;
            current = current.next;
        }
        return null;
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }
    
    public void deleteTask(int id) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.task.taskId == id) {
            head = head.next;
            System.out.println("Task deleted.");
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.task.taskId == id) {
                current.next = current.next.next;
                System.out.println("Task deleted.");
                return;
            }
            current = current.next;
        }
        System.out.println("Task not found.");
    }

    public static void main(String[] args) {
        TaskManagementSystem system = new TaskManagementSystem();

        system.addTask(new Task(1, "Design UI", "Pending"));
        system.addTask(new Task(2, "Implement Backend", "In Progress"));
        system.addTask(new Task(3, "Testing", "Pending"));

        System.out.println("All Tasks:");
        system.displayTasks();

        System.out.println("\nSearching for Task with ID 2:");
        Task found = system.searchTask(2);
        System.out.println(found != null ? found : "Task not found");

        System.out.println("\nDeleting Task with ID 1:");
        system.deleteTask(1);
        System.out.println("Tasks after deletion:");
        system.displayTasks();
    }
}
