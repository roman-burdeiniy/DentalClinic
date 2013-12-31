package ua.com.dentalclinic.vo.base;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 12/30/13
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "treatment_category", schema = "", catalog = "dentalclinicdb")
@Entity
@NamedQueries({
        @NamedQuery(name="TreatmentCategoryVO.getAll", query="SELECT c FROM TreatmentCategoryVO c"),
        @NamedQuery(name="TreatmentCategoryVO.getAllByLangId", query="SELECT c FROM TreatmentCategoryVO c JOIN " +
                "c.treatmentCategoryTranslationsesById tr WHERE tr.langId = :langId")
})
public class TreatmentCategoryVO {
    private int id;
    private String name;

    @javax.persistence.Column(name = "Id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @javax.persistence.Column(name = "Name")
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreatmentCategoryVO that = (TreatmentCategoryVO) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    private Collection<TreatmentCategoryTranslationsVO> treatmentCategoryTranslationsesById = new ArrayList<TreatmentCategoryTranslationsVO>();

    @OneToMany(mappedBy = "treatmentCategoryByCategoryId", cascade = CascadeType.PERSIST)
    public Collection<TreatmentCategoryTranslationsVO> getTreatmentCategoryTranslationsesById() {
        return treatmentCategoryTranslationsesById;
    }

    public void setTreatmentCategoryTranslationsesById(Collection<TreatmentCategoryTranslationsVO> treatmentCategoryTranslationsesById) {
        this.treatmentCategoryTranslationsesById = treatmentCategoryTranslationsesById;
    }

    private Collection<TreatmentsVO> treatmentsesById;

    @OneToMany(mappedBy = "treatmentCategoryByCategoryId", fetch = FetchType.LAZY)
    public Collection<TreatmentsVO> getTreatmentsesById() {
        return treatmentsesById;
    }

    public void setTreatmentsesById(Collection<TreatmentsVO> treatmentsesById) {
        this.treatmentsesById = treatmentsesById;
    }
}
