package uni.db.project.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dimitry on 17.03.17.
 */
@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id", nullable = false)
    private Faculty faculty;

    @Column(name = "number", nullable = false)
    private int number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "speciality_id", nullable = false)
    private Speciality speciality;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "education_form_id", nullable = false)
    private EducationForm educationForm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "qualification_level_id", nullable = false)
    private QualificationLevel qualificationLevel;

    @Column(name = "course", nullable = false)
    private int course;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_status_id", nullable = false)
    private GroupStatus groupStatus;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    private Set<Student> students = new HashSet<>();


    public Group() {
    }

    public Group(Faculty faculty, int number, Speciality speciality, Department department, EducationForm educationForm, QualificationLevel qualificationLevel, int course, GroupStatus groupStatus) {
        this.faculty = faculty;
        this.number = number;
        this.speciality = speciality;
        this.department = department;
        this.educationForm = educationForm;
        this.qualificationLevel = qualificationLevel;
        this.course = course;
        this.groupStatus = groupStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public EducationForm getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(EducationForm educationForm) {
        this.educationForm = educationForm;
    }

    public QualificationLevel getQualificationLevel() {
        return qualificationLevel;
    }

    public void setQualificationLevel(QualificationLevel qualificationLevel) {
        this.qualificationLevel = qualificationLevel;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public GroupStatus getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(GroupStatus groupStatus) {
        this.groupStatus = groupStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (id != group.id) return false;
        if (number != group.number) return false;
        if (course != group.course) return false;
        if (faculty != null ? !faculty.equals(group.faculty) : group.faculty != null) return false;
        if (speciality != null ? !speciality.equals(group.speciality) : group.speciality != null) return false;
        if (department != null ? !department.equals(group.department) : group.department != null) return false;
        if (educationForm != null ? !educationForm.equals(group.educationForm) : group.educationForm != null)
            return false;
        if (qualificationLevel != null ? !qualificationLevel.equals(group.qualificationLevel) : group.qualificationLevel != null)
            return false;
        return groupStatus != null ? groupStatus.equals(group.groupStatus) : group.groupStatus == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (faculty != null ? faculty.hashCode() : 0);
        result = 31 * result + number;
        result = 31 * result + (speciality != null ? speciality.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (educationForm != null ? educationForm.hashCode() : 0);
        result = 31 * result + (qualificationLevel != null ? qualificationLevel.hashCode() : 0);
        result = 31 * result + course;
        result = 31 * result + (groupStatus != null ? groupStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", faculty=" + faculty +
                ", number=" + number +
                ", speciality=" + speciality +
                ", department=" + department +
                ", educationForm=" + educationForm +
                ", qualificationLevel=" + qualificationLevel +
                ", course=" + course +
                ", groupStatus=" + groupStatus +
                '}';
    }
}
