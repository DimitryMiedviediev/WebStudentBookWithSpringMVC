package uni.db.project.entity;

import javax.persistence.*;

/**
 * Created by Dimitry on 19.04.17.
 */
@Entity
@Table(name = "psevdogroups")
public class Psevdogroup {

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

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "psevdogroup")
    private Student student;

    public Psevdogroup() {
    }

    public Psevdogroup(Faculty faculty, int number, Speciality speciality, Department department, EducationForm educationForm, QualificationLevel qualificationLevel, int course) {
        this.faculty = faculty;
        this.number = number;
        this.speciality = speciality;
        this.department = department;
        this.educationForm = educationForm;
        this.qualificationLevel = qualificationLevel;
        this.course = course;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Psevdogroup that = (Psevdogroup) o;

        if (id != that.id) return false;
        if (number != that.number) return false;
        if (course != that.course) return false;
        if (faculty != null ? !faculty.equals(that.faculty) : that.faculty != null) return false;
        if (speciality != null ? !speciality.equals(that.speciality) : that.speciality != null) return false;
        if (department != null ? !department.equals(that.department) : that.department != null) return false;
        if (educationForm != null ? !educationForm.equals(that.educationForm) : that.educationForm != null)
            return false;
        return qualificationLevel != null ? qualificationLevel.equals(that.qualificationLevel) : that.qualificationLevel == null;
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
        return result;
    }

    @Override
    public String toString() {
        return "Psevdogroup{" +
                "id=" + id +
                ", faculty=" + faculty +
                ", number=" + number +
                ", speciality=" + speciality +
                ", department=" + department +
                ", educationForm=" + educationForm +
                ", qualificationLevel=" + qualificationLevel +
                ", course=" + course +
                '}';
    }
}
