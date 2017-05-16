package uni.db.project.dao;

import uni.db.project.entity.Faculty;

import java.util.List;

/**
 * Created by Dimitry on 16.05.17.
 */
public interface FacultyDAO {

    void createFaculty(Faculty faculty);

    Faculty readFaculty(int id);

    void updateFaculty(int id, Faculty faculty);

    void deleteFaculty(int id);

    List<Faculty> getFacultyList();

}
