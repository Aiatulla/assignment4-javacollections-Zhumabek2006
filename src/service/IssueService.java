package service;

import model.Issue;
import java.util.PriorityQueue;
import java.util.Iterator;

public class IssueService {

    private PriorityQueue<Issue> issues = new PriorityQueue<>();

    public void initializeIssues() {
        issues.add(new Issue("Failed final exam", 2));
        issues.add(new Issue("Scholarship revoked", 1));
        issues.add(new Issue("Missing transcript", 4));
        issues.add(new Issue("Course registration error", 3));
        issues.add(new Issue("Dormitory issue", 5));
    }

    public void showMostUrgent() {
        if (!issues.isEmpty()) {
            System.out.println("Most urgent issue: " + issues.peek());
        } else {
            System.out.println("No issues.");
        }
    }

    public void resolveIssues() {
        for (int i = 0; i < 2; i++) {
            if (!issues.isEmpty()) {
                Issue resolved = issues.poll();
                System.out.println("Resolved: " + resolved);
            }
        }
    }

    public void printRemainingIssues() {
        System.out.println("=== Remaining Issues ===");
        Iterator<Issue> it = issues.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void addNewIssue(String description, int urgency) {
        Issue newIssue = new Issue(description, urgency);
        issues.add(newIssue);
        System.out.println("Added new issue: " + newIssue);
    }
}
