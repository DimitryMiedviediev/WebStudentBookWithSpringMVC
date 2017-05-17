package uni.db.project.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dimitry on 08.04.17.
 */
@Entity
@Table(name = "financing")
public class Financing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "financing_title", unique = true, nullable = false)
    private String financingTitle;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "financing")
    private Set<Student> students = new HashSet<>();


    public Financing() {
    }

    public Financing(String financingTitle) {
        this.financingTitle = financingTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFinancingTitle() {
        return financingTitle;
    }

    public void setFinancingTitle(String financingTitle) {
        this.financingTitle = financingTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Financing financing = (Financing) o;

        if (id != financing.id) return false;
        return financingTitle != null ? financingTitle.equals(financing.financingTitle) : financing.financingTitle == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (financingTitle != null ? financingTitle.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Financing{" +
                "id=" + id +
                ", financingTitle='" + financingTitle + '\'' +
                '}';
    }
}
