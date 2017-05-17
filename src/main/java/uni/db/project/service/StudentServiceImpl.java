//package uni.db.project.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import uni.db.project.dao.StudentDAO;
//import uni.db.project.entity.Student;
//
//import java.util.List;
//
///**
// * Created by Dimitry on 17.05.17.
// */
//@Service
//public class StudentServiceImpl implements StudentService{
//
//    @Autowired
//    StudentDAO studentDAO;
//
//
//    @Override
//    public void createStudent(Student student) {
//        studentDAO.createStudent(student);
//    }
//
//    @Override
//    public Student readStudent(int id) {
//        return studentDAO.readStudent(id);
//    }
//
//    @Override
//    public void updateStudent(int id, Student student) {
//        studentDAO.updateStudent(id, student);
//    }
//
//    @Override
//    public void deleteStudent(int id) {
//        studentDAO.deleteStudent(id);
//    }
//
//    @Override
//    public List<Student> getStudentList() {
//        return studentDAO.getStudentList();
//    }
//}
