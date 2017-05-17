package uni.db.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.db.project.dao.*;
import uni.db.project.entity.*;

import java.util.List;

/**
 * Created by Dimitry on 17.05.17.
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDAO groupDAO;

    @Autowired
    private FacultyDAO facultyDAO;

    @Autowired
    private SpecialityDAO specialityDAO;

    @Autowired
    private DepartmentDAO departmentDAO;

    @Autowired
    private EducationFormDAO educationFormDAO;

    @Autowired
    private QualificationLevelDAO qualificationLevelDAO;

    @Autowired
    private GroupStatusDAO groupStatusDAO;

    @Override
    public void createGroup(Group group) {
        groupDAO.createGroup(group);
    }

    @Override
    public Group readGroup(int id) {
        return groupDAO.readGroup(id);
    }

    @Override
    public void updateGroup(int id, Group group) {
        groupDAO.updateGroup(id, group);
    }

    @Override
    public void deleteGroup(int id) {
        groupDAO.deleteGroup(id);
    }

    @Override
    public List<Group> getGroupList() {
        return groupDAO.getGroupList();
    }

    @Override
    public Faculty readFaculty(int id) {
        return facultyDAO.readFaculty(id);
    }

    @Override
    public List<Faculty> getFacultyList() {
        return facultyDAO.getFacultyList();
    }

    @Override
    public Speciality readSpeciality(int id) {
        return specialityDAO.readSpeciality(id);
    }

    @Override
    public List<Speciality> getSpecialityList() {
        return specialityDAO.getSpecialityList();
    }

    @Override
    public Department readDepartment(int id) {
        return departmentDAO.readDepartment(id);
    }

    @Override
    public List<Department> getDepartmentList() {
        return departmentDAO.getDepartmentList();
    }

    @Override
    public EducationForm readEducationForm(int id) {
        return educationFormDAO.readEducationForm(id);
    }

    @Override
    public List<EducationForm> getEducationFormList() {
        return educationFormDAO.getEducationFormList();
    }

    @Override
    public QualificationLevel readQualificationLevel(int id) {
        return qualificationLevelDAO.readQualificationLevel(id);
    }

    @Override
    public List<QualificationLevel> getQualificationLevelList() {
        return qualificationLevelDAO.getQualificationLevelList();
    }

    @Override
    public GroupStatus readGroupStatus(int id) {
        return groupStatusDAO.readGroupStatus(id);
    }

    @Override
    public List<GroupStatus> getGroupStatusList() {
        return groupStatusDAO.getGroupStatusList();
    }
}
