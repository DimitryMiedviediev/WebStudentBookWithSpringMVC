package uni.db.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uni.db.project.entity.Group;

import java.util.List;

/**
 * Created by Dimitry on 17.05.17.
 */
@Repository
public class GroupDAOImpl implements GroupDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createGroup(Group group) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(group);
    }

    @Override
    public Group readGroup(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Group.class, id);
    }

    @Override
    public void updateGroup(int id, Group group) {
        Session session = sessionFactory.getCurrentSession();
        Group oldGroup = session.get(Group.class, id);
        oldGroup.setFaculty(group.getFaculty());
        oldGroup.setNumber(group.getNumber());
        oldGroup.setSpeciality(group.getSpeciality());
        oldGroup.setDepartment(group.getDepartment());
        oldGroup.setEducationForm(group.getEducationForm());
        oldGroup.setQualificationLevel(group.getQualificationLevel());
        oldGroup.setCourse(group.getCourse());
        oldGroup.setGroupStatus(group.getGroupStatus());
        session.persist(oldGroup);
    }

    @Override
    public void deleteGroup(int id) {
        Session session = sessionFactory.getCurrentSession();
        Group group = session.get(Group.class, id);
        session.delete(group);
    }

    @Override
    public List<Group> getGroupList() {
        Session session = sessionFactory.getCurrentSession();
        List<Group> groupList = session.createQuery("FROM Group", Group.class).getResultList();
        return groupList;
    }
}
