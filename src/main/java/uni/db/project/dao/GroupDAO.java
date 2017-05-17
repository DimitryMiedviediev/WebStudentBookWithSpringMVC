package uni.db.project.dao;

import uni.db.project.entity.Group;

import java.util.List;

/**
 * Created by Dimitry on 17.05.17.
 */
public interface GroupDAO {

    void createGroup(Group group);

    Group readGroup(int id);

    void updateGroup(int id, Group group);

    void deleteGroup(int id);

    List<Group> getGroupList();

}
