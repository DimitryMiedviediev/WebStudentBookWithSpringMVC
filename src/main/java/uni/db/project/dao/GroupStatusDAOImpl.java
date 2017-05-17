package uni.db.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uni.db.project.entity.GroupStatus;

import java.util.List;

/**
 * Created by Dimitry on 17.05.17.
 */
@Repository
public class GroupStatusDAOImpl implements GroupStatusDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createGroupStatus(GroupStatus groupStatus) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(groupStatus);
    }

    @Override
    public GroupStatus readGroupStatus(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(GroupStatus.class, id);
    }

    @Override
    public void updateGroupStatus(int id, GroupStatus groupStatus) {
        Session session = sessionFactory.getCurrentSession();
        GroupStatus oldGroupStatus = session.get(GroupStatus.class, id);
        oldGroupStatus.setGroupStatusTitle(groupStatus.getGroupStatusTitle());
        session.persist(oldGroupStatus);
    }

    @Override
    public void deleteGroupStatus(int id) {
        Session session = sessionFactory.getCurrentSession();
        GroupStatus groupStatus = session.get(GroupStatus.class, id);
        session.delete(groupStatus);
    }

    @Override
    public List<GroupStatus> getGroupStatusList() {
        Session session = sessionFactory.getCurrentSession();
        List<GroupStatus> groupStatusList = session.createQuery("FROM GroupStatus", GroupStatus.class).getResultList();
        return groupStatusList;
    }
}
