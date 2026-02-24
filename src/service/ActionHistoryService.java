package service;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ActionHistoryService {

    private ArrayDeque<String> actions = new ArrayDeque<>();

    public void initializeActions() {
        actions.push("Submitted Assignment");
        actions.push("Dropped Course");
        actions.push("Registered Course");
        actions.push("Updated Profile");
    }

    public void undoLastAction() {
        if (!actions.isEmpty()) {
            String undone = actions.pop();
            System.out.println("Undone action: " + undone);
        } else {
            System.out.println("No actions to undo.");
        }
    }

    public void addRequestedTranscript() {
        actions.push("Requested Transcript");
        System.out.println("Added action: Requested Transcript");
    }

    public void showFirstAndLast() {
        if (!actions.isEmpty()) {
            System.out.println("First action: " + actions.peekLast());
            System.out.println("Last action: " + actions.peekFirst());
        } else {
            System.out.println("No actions.");
        }
    }

    public void printHistory() {
        System.out.println("=== Action History ===");
        Iterator<String> it = actions.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
