package uni.db.project.entity.group;

import uni.db.project.entity.Department;
import uni.db.project.entity.Faculty;
import uni.db.project.entity.Speciality;
import uni.db.project.entity.group.parameters.EducationForm;
import uni.db.project.entity.group.parameters.QualificationLevel;
import uni.db.project.entity.group.parameters.GroupStatus;

import javax.persistence.*;

/**
 * Created by Dimitry on 17.03.17.
 */
@Entity
@Table(name = "group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "faculty_id", nullable = false)
//    private Faculty faculty;

//    @Column(name = "group_number", nullable = false)
//    private int groupNumber;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "speciality_id", nullable = false)
//    private Speciality speciality;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "department_id", nullable = false)
//    private Department department;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "education_form_id", nullable = false)
//    private EducationForm educationForm;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "qualification_level_id", nullable = false)
//    private QualificationLevel qualificationLevel;

//    @Column(name = "group_course", nullable = false)
//    private int groupCourse;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "group_status_id", nullable = false)
//    private GroupStatus groupStatus;




//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "group")
//    private Set<Student> students = new HashSet<>();

    public Group() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        return id == group.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                '}';
    }
}
