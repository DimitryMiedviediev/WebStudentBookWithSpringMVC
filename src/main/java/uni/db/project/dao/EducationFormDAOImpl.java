package uni.db.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uni.db.project.entity.EducationForm;

import java.util.List;

/**
 * Created by Dimitry on 17.05.17.
 */
@Repository
public class EducationFormDAOImpl implements EducationFormDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createEducationForm(EducationForm educationForm) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(educationForm);
    }

    @Override
    public EducationForm readEducationForm(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(EducationForm.class, id);
    }

    @Override
    public void updateEducationForm(int id, EducationForm educationForm) {
        Session session = sessionFactory.getCurrentSession();
        EducationForm oldEducationForm = session.get(EducationForm.class, id);
        oldEducationForm.setEducationFormTitle(educationForm.getEducationFormTitle());
        session.persist(oldEducationForm);
    }

    @Override
    public void deleteEducationForm(int id) {
        Session session = sessionFactory.getCurrentSession();
        EducationForm educationForm = session.get(EducationForm.class, id);
        session.delete(educationForm);
    }

    @Override
    public List<EducationForm> getEducationFormList() {
        Session session = sessionFactory.getCurrentSession();
        List<EducationForm> educationFormList = session.createQuery("FROM EducationForm", EducationForm.class).getResultList();
        return educationFormList;
    }
}
