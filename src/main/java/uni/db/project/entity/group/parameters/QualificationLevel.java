package uni.db.project.entity.group.parameters;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dimitry on 04.04.17.
 */
@Entity
@Table(name = "qualificationLevel")
public class QualificationLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "qualification_level_title", unique = true, nullable = false)
    private String title;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "qualificationLevel")
//    private Set<Group> groups = new HashSet<>();

    public QualificationLevel() {
    }

    public QualificationLevel(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

        QualificationLevel that = (QualificationLevel) o;

        if (id != that.id) return false;
        return title != null ? title.equals(that.title) : that.title == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "QualificationLevel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
