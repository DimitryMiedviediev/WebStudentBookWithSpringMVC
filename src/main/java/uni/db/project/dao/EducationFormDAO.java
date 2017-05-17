package uni.db.project.dao;

import uni.db.project.entity.EducationForm;

import java.util.List;

/**
 * Created by Dimitry on 17.05.17.
 */
public interface EducationFormDAO {

    void createEducationForm(EducationForm educationForm);

    EducationForm readEducationForm(int id);

    void updateEducationForm(int id, EducationForm educationForm);

    void deleteEducationForm(int id);

    List<EducationForm> getEducationFormList();

}
