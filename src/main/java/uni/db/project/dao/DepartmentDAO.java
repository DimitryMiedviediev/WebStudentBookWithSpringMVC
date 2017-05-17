package uni.db.project.dao;

import uni.db.project.entity.Department;
import uni.db.project.entity.Faculty;

import java.util.List;

/**
 * Created by Dimitry on 17.05.17.
 */
public interface DepartmentDAO {

    void createDepartment(Department department);

    Department readDepartment(int id);

    void updateDepartment(int id, Department department);

    void deleteDepartment(int id);

    List<Department> getDepartmentList();

}
