import service.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentService studentService = new StudentService();
        AppointmentService appointmentService = new AppointmentService();
        IssueService issueService = new IssueService();
        ActionHistoryService actionService = new ActionHistoryService();

        // Initialize all data
        studentService.initializeStudents();
        appointmentService.initializeAppointments();
        issueService.initializeIssues();
        actionService.initializeActions();

        // Perform initial tasks as per requirements
        System.out.println("===== Initial Setup =====\n");

        // 1) Student tasks
        System.out.println("--- Student Database (ArrayList) ---");
        studentService.printStudents();
        System.out.println();
        studentService.removeLowGPA();
        System.out.println();
        studentService.findHighestGPA();
        studentService.insertAtIndex();
        System.out.println();
        studentService.printStudents();
        System.out.println();

        // 2) Appointment tasks
        System.out.println("--- Appointments (LinkedList) ---");
        appointmentService.printAppointments();
        System.out.println();
        appointmentService.cancelLast();
        appointmentService.showFirstAndLast();
        System.out.println();
        appointmentService.printAppointments();
        System.out.println();

        // 3) Issue tasks
        System.out.println("--- Emergency Issues (PriorityQueue) ---");
        issueService.showMostUrgent();
        issueService.resolveIssues();
        System.out.println();
        issueService.printRemainingIssues();
        System.out.println();

        // 4) Action History tasks
        System.out.println("--- Action History (ArrayDeque) ---");
        actionService.printHistory();
        System.out.println();
        actionService.undoLastAction();
        actionService.addRequestedTranscript();
        actionService.showFirstAndLast();
        System.out.println();
        actionService.printHistory();
        System.out.println();

        // Menu-driven system
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("===== 🎓 Smart University Service System =====");
            System.out.println("1. Show Students");
            System.out.println("2. Show Appointments");
            System.out.println("3. Show Emergency Issues");
            System.out.println("4. Show Action History");
            System.out.println("5. Add New Issue");
            System.out.println("6. Undo Action");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    studentService.printStudents();
                    break;
                case 2:
                    appointmentService.printAppointments();
                    appointmentService.showFirstAndLast();
                    break;
                case 3:
                    issueService.showMostUrgent();
                    issueService.printRemainingIssues();
                    break;
                case 4:
                    actionService.printHistory();
                    actionService.showFirstAndLast();
                    break;
                case 5:
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter issue description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter urgency level (1 = most urgent): ");
                    int urgency = scanner.nextInt();
                    issueService.addNewIssue(description, urgency);
                    break;
                case 6:
                    actionService.undoLastAction();
                    break;
                case 7:
                    System.out.println("Exiting... 👋");
                    break;
                default:
                    System.out.println("Invalid option ❌");
            }

        } while (choice != 7);

        scanner.close();
    }
}
