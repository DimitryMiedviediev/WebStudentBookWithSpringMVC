package uni.db.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uni.db.project.entity.Speciality;

import java.util.List;

/**
 * Created by Dimitry on 17.05.17.
 */
@Repository
public class SpecialityDAOImpl implements SpecialityDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createSpeciality(Speciality speciality) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(speciality);
    }

    @Override
    public Speciality readSpeciality(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Speciality.class, id);
    }

    @Override
    public void updateSpeciality(int id, Speciality speciality) {
        Session session = sessionFactory.getCurrentSession();
        Speciality oldSpeciality = session.get(Speciality.class, id);
        oldSpeciality.setTitle(speciality.getTitle());
        session.persist(oldSpeciality);
    }

    @Override
    public void deleteSpeciality(int id) {
        Session session = sessionFactory.getCurrentSession();
        Speciality speciality = session.get(Speciality.class, id);
        session.delete(speciality);
    }

    @Override
    public List<Speciality> getSpecialityList() {
        Session session = sessionFactory.getCurrentSession();
        List<Speciality> specialityList = session.createQuery("FROM Speciality", Speciality.class).getResultList();
        return specialityList;
    }
}
