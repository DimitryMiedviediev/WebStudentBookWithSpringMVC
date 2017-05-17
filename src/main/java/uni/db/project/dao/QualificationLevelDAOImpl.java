package uni.db.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uni.db.project.entity.QualificationLevel;

import java.util.List;

/**
 * Created by Dimitry on 17.05.17.
 */
@Repository
public class QualificationLevelDAOImpl implements QualificationLevelDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createQualificationLevel(QualificationLevel qualificationLevel) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(qualificationLevel);
    }

    @Override
    public QualificationLevel readQualificationLevel(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(QualificationLevel.class, id);
    }

    @Override
    public void updateQualificationLevel(int id, QualificationLevel qualificationLevel) {
        Session session = sessionFactory.getCurrentSession();
        QualificationLevel oldQualificationLevel = session.get(QualificationLevel.class, id);
        oldQualificationLevel.setTitle(qualificationLevel.getTitle());
        session.persist(oldQualificationLevel);
    }

    @Override
    public void deleteQualificationLevel(int id) {
        Session session = sessionFactory.getCurrentSession();
        QualificationLevel qualificationLevel = session.get(QualificationLevel.class, id);
        session.delete(qualificationLevel);
    }

    @Override
    public List<QualificationLevel> getQualificationLevelList() {
        Session session = sessionFactory.getCurrentSession();
        List<QualificationLevel> qualificationLevelList = session.createQuery("FROM QualificationLevel", QualificationLevel.class).getResultList();
        return qualificationLevelList;
    }
}
