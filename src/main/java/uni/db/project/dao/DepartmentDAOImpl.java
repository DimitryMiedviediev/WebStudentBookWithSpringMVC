package uni.db.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uni.db.project.entity.Department;

import java.util.List;

/**
 * Created by Dimitry on 17.05.17.
 */
@Repository
public class DepartmentDAOImpl implements DepartmentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createDepartment(Department department) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(department);
    }

    @Override
    public Department readDepartment(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Department.class, id);
    }

    @Override
    public void updateDepartment(int id, Department department) {
        Session session = sessionFactory.getCurrentSession();
        Department oldDepartment = session.get(Department.class, id);
        oldDepartment.setFaculty(department.getFaculty());
        oldDepartment.setTitle(department.getTitle());
        session.persist(oldDepartment);
    }

    @Override
    public void deleteDepartment(int id) {
        Session session = sessionFactory.getCurrentSession();
        Department department = session.get(Department.class, id);
        session.delete(department);
    }

    @Override
    public List<Department> getDepartmentList() {
        Session session = sessionFactory.getCurrentSession();
        List<Department> departmentList = session.createQuery("FROM Department", Department.class).getResultList();
        return departmentList;
    }
}
