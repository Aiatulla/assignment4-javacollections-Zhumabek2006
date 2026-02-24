package service;

import java.util.LinkedList;
import java.util.Iterator;

public class AppointmentService {

    private LinkedList<String> appointments = new LinkedList<>();

    public void initializeAppointments() {
        // Add 3 normal appointments
        appointments.add("Meeting with Advisor - Math");
        appointments.add("Meeting with Advisor - Physics");
        appointments.add("Meeting with Advisor - CS");
        // Add 1 urgent appointment at the beginning
        appointments.addFirst("URGENT: Academic Probation Meeting");
    }

    public void cancelLast() {
        if (!appointments.isEmpty()) {
            String removed = appointments.removeLast();
            System.out.println("Cancelled last appointment: " + removed);
        } else {
            System.out.println("No appointments to cancel.");
        }
    }

    public void showFirstAndLast() {
        if (!appointments.isEmpty()) {
            System.out.println("First appointment: " + appointments.getFirst());
            System.out.println("Last appointment: " + appointments.getLast());
        } else {
            System.out.println("No appointments.");
        }
    }

    public void printAppointments() {
        System.out.println("=== All Appointments ===");
        Iterator<String> it = appointments.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
