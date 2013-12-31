package ua.com.dentalclinic.vo.base;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 12/30/13
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "treatments", schema = "", catalog = "dentalclinicdb")
@Entity
@NamedQueries({
        @NamedQuery(name="TreatmentVO.getAllByLangId", query="SELECT t FROM TreatmentsVO t JOIN " +
                "t.treatmentsTranslationsesById tr WHERE tr.langId = ?1"),
        @NamedQuery(name="TreatmentVO.getTreatmentsByCatIdAndLangId", query="SELECT t FROM TreatmentsVO t JOIN " +
                "t.treatmentsTranslationsesById tr WHERE tr.langId = :langId AND t.treatmentCategoryByCategoryId.id IN :catIds"),
        @NamedQuery(name="TreatmentVO.getNonCatigorized", query="SELECT t FROM TreatmentsVO t JOIN " +
                "t.treatmentsTranslationsesById tr WHERE tr.langId = :langId AND t.treatmentCategoryByCategoryId.id IS NULL")
})
public class TreatmentsVO {
    private int id;

    @javax.persistence.Column(name = "Id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Integer lowPrice;

    @javax.persistence.Column(name = "LowPrice")
    @Basic
    public Integer getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Integer lowPrice) {
        this.lowPrice = lowPrice;
    }

    private Integer topPrice;

    @javax.persistence.Column(name = "TopPrice")
    @Basic
    public Integer getTopPrice() {
        return topPrice;
    }

    public void setTopPrice(Integer topPrice) {
        this.topPrice = topPrice;
    }

    private String guaranty;

    @javax.persistence.Column(name = "Guaranty")
    @Basic
    public String getGuaranty() {
        return guaranty;
    }

    public void setGuaranty(String guaranty) {
        this.guaranty = guaranty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreatmentsVO that = (TreatmentsVO) o;

        if (id != that.id) return false;
        if (guaranty != null ? !guaranty.equals(that.guaranty) : that.guaranty != null) return false;
        if (lowPrice != null ? !lowPrice.equals(that.lowPrice) : that.lowPrice != null) return false;
        if (topPrice != null ? !topPrice.equals(that.topPrice) : that.topPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (lowPrice != null ? lowPrice.hashCode() : 0);
        result = 31 * result + (topPrice != null ? topPrice.hashCode() : 0);
        result = 31 * result + (guaranty != null ? guaranty.hashCode() : 0);
        return result;
    }

    private TreatmentCategoryVO treatmentCategoryByCategoryId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "CategoryId", referencedColumnName = "Id")
    public TreatmentCategoryVO getTreatmentCategoryByCategoryId() {
        return treatmentCategoryByCategoryId;
    }

    public void setTreatmentCategoryByCategoryId(TreatmentCategoryVO treatmentCategoryByCategoryId) {
        this.treatmentCategoryByCategoryId = treatmentCategoryByCategoryId;
    }

    private TreatmentsVO treatmentsByParentTreatmentId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "ParentTreatmentId", referencedColumnName = "Id")
    public TreatmentsVO getTreatmentsByParentTreatmentId() {
        return treatmentsByParentTreatmentId;
    }

    public void setTreatmentsByParentTreatmentId(TreatmentsVO treatmentsByParentTreatmentId) {
        this.treatmentsByParentTreatmentId = treatmentsByParentTreatmentId;
    }

    private Collection<TreatmentsVO> treatmentsesById;

    @OneToMany(mappedBy = "treatmentsByParentTreatmentId")
    public Collection<TreatmentsVO> getTreatmentsesById() {
        return treatmentsesById;
    }

    public void setTreatmentsesById(Collection<TreatmentsVO> treatmentsesById) {
        this.treatmentsesById = treatmentsesById;
    }

    private Collection<TreatmentsImagesVO> treatmentsImagesesById;

    @OneToMany(mappedBy = "treatmentsByTreatmentId")
    public Collection<TreatmentsImagesVO> getTreatmentsImagesesById() {
        return treatmentsImagesesById;
    }

    public void setTreatmentsImagesesById(Collection<TreatmentsImagesVO> treatmentsImagesesById) {
        this.treatmentsImagesesById = treatmentsImagesesById;
    }


    private Collection<TreatmentsTranslationsVO> treatmentsTranslationsesById;

    @OneToMany(mappedBy = "treatmentsByTreatmentId", cascade = CascadeType.PERSIST)
    public Collection<TreatmentsTranslationsVO> getTreatmentsTranslationsesById() {
        return treatmentsTranslationsesById;
    }

    public void setTreatmentsTranslationsesById(Collection<TreatmentsTranslationsVO> treatmentsTranslationsesById) {
        this.treatmentsTranslationsesById = treatmentsTranslationsesById;
    }


}
