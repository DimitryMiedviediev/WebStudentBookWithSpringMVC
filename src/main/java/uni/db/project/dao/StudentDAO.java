package uni.db.project.dao;

import uni.db.project.entity.Student;

import java.util.List;

/**
 * Created by Dimitry on 17.05.17.
 */
public interface StudentDAO {

    void createStudent(Student student);

    Student readStudent(int id);

    void updateStudent(int id, Student student);

    void deleteStudent(int id);

    List<Student> getStudentList();

}
