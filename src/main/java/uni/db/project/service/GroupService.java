package uni.db.project.service;

import uni.db.project.entity.*;

import java.util.List;

/**
 * Created by Dimitry on 17.05.17.
 */
public interface GroupService {

    void createGroup(Group group);

    Group readGroup(int id);

    void updateGroup(int id, Group group);

    void deleteGroup(int id);

    List<Group> getGroupList();

    Faculty readFaculty(int id);

    List<Faculty> getFacultyList();

    Speciality readSpeciality(int id);

    List<Speciality> getSpecialityList();

    Department readDepartment(int id);

    List<Department> getDepartmentList();

    EducationForm readEducationForm(int id);

    List<EducationForm> getEducationFormList();

    QualificationLevel readQualificationLevel(int id);

    List<QualificationLevel> getQualificationLevelList();

    GroupStatus readGroupStatus(int id);

    List<GroupStatus> getGroupStatusList();

}
