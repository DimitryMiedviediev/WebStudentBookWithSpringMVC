package uni.db.project.dao;

import uni.db.project.entity.GroupStatus;

import java.util.List;

/**
 * Created by Dimitry on 17.05.17.
 */
public interface GroupStatusDAO {

    void createGroupStatus(GroupStatus groupStatus);

    GroupStatus readGroupStatus(int id);

    void updateGroupStatus(int id, GroupStatus groupStatus);

    void deleteGroupStatus(int id);

    List<GroupStatus> getGroupStatusList();

}
