package uni.db.project.dao;

import uni.db.project.entity.QualificationLevel;

import java.util.List;

/**
 * Created by Dimitry on 17.05.17.
 */
public interface QualificationLevelDAO {

    void createQualificationLevel(QualificationLevel qualificationLevel);

    QualificationLevel readQualificationLevel(int id);

    void updateQualificationLevel(int id, QualificationLevel qualificationLevel);

    void deleteQualificationLevel(int id);

    List<QualificationLevel> getQualificationLevelList();

}
