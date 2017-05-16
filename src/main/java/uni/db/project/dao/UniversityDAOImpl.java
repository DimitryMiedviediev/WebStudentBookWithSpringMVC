package uni.db.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uni.db.project.entity.Address;
import uni.db.project.entity.Person;
import uni.db.project.entity.University;

import java.util.List;

/**
 * Created by Dimitry on 16.05.17.
 */
@Repository
public class UniversityDAOImpl implements UniversityDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createUniversity(University university) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(university);
    }

    @Override
    public University readUniversity(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(University.class, id);
    }

    @Override
    public void updateUniversity(int id, University university) {
        Session session = sessionFactory.getCurrentSession();
        University oldUniversity = session.get(University.class, id);
        oldUniversity.setTitle(university.getTitle());
        oldUniversity.setMotto(university.getMotto());
        oldUniversity.setDateFound(university.getDateFound());
        oldUniversity.setType(university.getType());
        oldUniversity.setPresident(university.getPresident());
        oldUniversity.setAddress(university.getAddress());
        oldUniversity.setWebSite(university.getWebSite());
        session.persist(oldUniversity);
    }

    @Override
    public void deleteUniversity(int id) {
        Session session = sessionFactory.getCurrentSession();
        University university = session.get(University.class, id);
        session.delete(university);
    }

    @Override
    public List<University> getUniversityList() {
        Session session = sessionFactory.getCurrentSession();
        List<University> universityList = session.createQuery("FROM University", University.class).getResultList();
        return universityList;
    }
}
