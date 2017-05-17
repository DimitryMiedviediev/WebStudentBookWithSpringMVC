package uni.db.project.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dimitry on 09.04.17.
 */
@Entity
@Table(name = "subgroup")
public class Subgroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "subgroup_title", unique = true, nullable = false)
    private String subgroupTitle;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subgroup")
    private Set<Student> students = new HashSet<>();

    public Subgroup() {
    }

    public Subgroup(String subgroupTitle) {
        this.subgroupTitle = subgroupTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubgroupTitle() {
        return subgroupTitle;
    }

    public void setSubgroupTitle(String subgroupTitle) {
        this.subgroupTitle = subgroupTitle;
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

        Subgroup subgroup = (Subgroup) o;

        if (id != subgroup.id) return false;
        return subgroupTitle != null ? subgroupTitle.equals(subgroup.subgroupTitle) : subgroup.subgroupTitle == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (subgroupTitle != null ? subgroupTitle.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Subgroup{" +
                "id=" + id +
                ", subgroupTitle='" + subgroupTitle + '\'' +
                '}';
    }
}
