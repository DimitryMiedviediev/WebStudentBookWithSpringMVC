package uni.db.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uni.db.project.entity.Faculty;

import java.util.List;

/**
 * Created by Dimitry on 16.05.17.
 */
@Repository
public class FacultyDAOImpl implements FacultyDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createFaculty(Faculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(faculty);
    }

    @Override
    public Faculty readFaculty(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Faculty.class, id);
    }

    @Override
    public void updateFaculty(int id, Faculty faculty) {
        Session session = sessionFactory.getCurrentSession();
        Faculty oldFaculty = session.get(Faculty.class, id);
        oldFaculty.setUniversity(faculty.getUniversity());
        oldFaculty.setTitle(faculty.getTitle());
        oldFaculty.setDean(faculty.getDean());
        session.persist(oldFaculty);
    }

    @Override
    public void deleteFaculty(int id) {
        Session session = sessionFactory.getCurrentSession();
        Faculty faculty = session.get(Faculty.class, id);
        session.delete(faculty);
    }

    @Override
    public List<Faculty> getFacultyList() {
        Session session = sessionFactory.getCurrentSession();
        List<Faculty> facultyList = session.createQuery("FROM Faculty", Faculty.class).getResultList();
        return facultyList;
    }
}
