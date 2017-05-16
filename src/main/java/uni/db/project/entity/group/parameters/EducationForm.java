package uni.db.project.entity.group.parameters;

import javax.persistence.*;

/**
 * Created by Dimitry on 04.04.17.
 */
@Entity
@Table(name = "educationForm")
public class EducationForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "education_form_title", unique = true, nullable = false)
    private String educationFormTitle;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "educationForm")
//    private Set<Group> groups = new HashSet<>();

    public EducationForm() {
    }

    public EducationForm(String educationFormTitle) {
        this.educationFormTitle = educationFormTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEducationFormTitle() {
        return educationFormTitle;
    }

    public void setEducationFormTitle(String educationFormTitle) {
        this.educationFormTitle = educationFormTitle;
    }

//    public Set<Group> getGroups() {
//        return groups;
//    }
//
//    public void setGroups(Set<Group> groups) {
//        this.groups = groups;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EducationForm that = (EducationForm) o;

        if (id != that.id) return false;
        return educationFormTitle != null ? educationFormTitle.equals(that.educationFormTitle) : that.educationFormTitle == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (educationFormTitle != null ? educationFormTitle.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EducationForm{" +
                "id=" + id +
                ", groupEducationFormTitle='" + educationFormTitle + '\'' +
                '}';
    }
}
