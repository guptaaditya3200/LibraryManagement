package Repository;

import entity.Student;
import java.util.*;

public class StudentRepository {
    private Map<String, Student> students = new HashMap<>();

    public void addStudent(Student student) {
        students.put(student.getStudentId(), student);
    }

    public Student getStudent(String id) {
        return students.get(id);
    }

    public boolean exists(String id) {
        return students.containsKey(id);
    }
}