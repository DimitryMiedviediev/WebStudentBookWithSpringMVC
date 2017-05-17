package uni.db.project.dao;

import uni.db.project.entity.Speciality;

import java.util.List;

/**
 * Created by Dimitry on 17.05.17.
 */
public interface SpecialityDAO {

    void createSpeciality(Speciality speciality);

    Speciality readSpeciality(int id);

    void updateSpeciality(int id, Speciality speciality);

    void deleteSpeciality(int id);

    List<Speciality> getSpecialityList();

}
