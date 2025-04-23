package Repository;

import java.util.*;

public class IssueHistoryRepository {
    private Map<String, List<String>> history = new HashMap<>();

    public void log(String studentId, String bookId) {
        history.computeIfAbsent(studentId, k -> new ArrayList<>()).add(bookId);
    }

    public List<String> getHistory(String studentId) {
        return history.getOrDefault(studentId, Collections.emptyList());
    }
}