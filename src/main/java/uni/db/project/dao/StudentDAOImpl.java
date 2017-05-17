package uni.db.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uni.db.project.entity.Student;

import java.util.List;

/**
 * Created by Dimitry on 17.05.17.
 */
@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(student);
    }

    @Override
    public Student readStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }

    @Override
    public void updateStudent(int id, Student student) {
        Session session = sessionFactory.getCurrentSession();
        Student oldStudent = session.get(Student.class, id);
        oldStudent.setStudent(student.getStudent());
        oldStudent.setStudentStatus(student.getStudentStatus());
        oldStudent.setGroup(student.getGroup());
        oldStudent.setPsevdogroup(student.getPsevdogroup());
        oldStudent.setSubgroup(student.getSubgroup());
        oldStudent.setStudentBook(student.getStudentBook());
        oldStudent.setStudentBirthDate(student.getStudentBirthDate());
        oldStudent.setStudentPassportNumber(student.getStudentPassportNumber());
        oldStudent.setStudentPassportOffice(student.getStudentPassportOffice());
        oldStudent.setStudentPassportReleaseDate(student.getStudentPassportReleaseDate());
        oldStudent.setStudentIdentityCode(student.getStudentIdentityCode());
        oldStudent.setStudentAddress(student.getStudentAddress());
        oldStudent.setFather(student.getFather());
        oldStudent.setMother(student.getMother());
        oldStudent.setParentAddress(student.getParentAddress());
        session.persist(oldStudent);
    }

    @Override
    public void deleteStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);
        session.delete(student);
    }

    @Override
    public List<Student> getStudentList() {
        Session session = sessionFactory.getCurrentSession();
        List<Student> studentList = session.createQuery("FROM Student", Student.class).getResultList();
        return studentList;
    }
}
