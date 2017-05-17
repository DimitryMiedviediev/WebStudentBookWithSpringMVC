package uni.db.project.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dimitry on 08.04.17.
 */
@Entity
@Table(name = "studentStatus")
public class StudentStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "status_title", unique = true, nullable = false)
    private String statusTitle;

    @Column(name = "status_role")
    private Boolean statusRole;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "studentStatus")
    private Set<Student> students = new HashSet<>();

    public StudentStatus() {
    }

    public StudentStatus(String statusTitle, Boolean statusRole) {
        this.statusTitle = statusTitle;
        this.statusRole = statusRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatusTitle() {
        return statusTitle;
    }

    public void setStatusTitle(String statusTitle) {
        this.statusTitle = statusTitle;
    }

    public Boolean getStatusRole() {
        return statusRole;
    }

    public void setStatusRole(Boolean statusRole) {
        this.statusRole = statusRole;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentStatus that = (StudentStatus) o;

        if (id != that.id) return false;
        if (statusTitle != null ? !statusTitle.equals(that.statusTitle) : that.statusTitle != null) return false;
        return statusRole != null ? statusRole.equals(that.statusRole) : that.statusRole == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (statusTitle != null ? statusTitle.hashCode() : 0);
        result = 31 * result + (statusRole != null ? statusRole.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StudentStatus{" +
                "id=" + id +
                ", statusTitle='" + statusTitle + '\'' +
                ", statusRole=" + statusRole +
                '}';
    }
}
