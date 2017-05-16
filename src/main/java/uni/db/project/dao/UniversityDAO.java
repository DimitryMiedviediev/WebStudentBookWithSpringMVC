package uni.db.project.dao;

import uni.db.project.entity.Address;
import uni.db.project.entity.Person;
import uni.db.project.entity.University;

import java.util.List;

/**
 * Created by Dimitry on 16.05.17.
 */
public interface UniversityDAO {

    void createUniversity(University university);

    University readUniversity(int id);

    void updateUniversity(int id, University university);

    void deleteUniversity(int id);

    List<University> getUniversityList();

}
