package ua.com.dentalclinic.vo.base;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 12/30/13
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.IdClass(ua.com.dentalclinic.vo.base.TreatmentsTranslationsVOPK.class)
@javax.persistence.Table(name = "treatments_translations", schema = "", catalog = "dentalclinicdb")
@Entity
public class TreatmentsTranslationsVO {
    private int treatmentId;

    @javax.persistence.Column(name = "TreatmentId", insertable = false, updatable = false)
    @Id
    public int getTreatmentId() {
        return treatmentId;
    }

    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
    }

    private int langId;

    @javax.persistence.Column(name = "LangId", insertable = false, updatable = false)
    @Id
    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    private String name;

    @javax.persistence.Column(name = "Name")
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String description = "";

    @javax.persistence.Column(name = "Description")
    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String guaranty = "";

    @javax.persistence.Column(name = "Guaranty")
    @Basic
    public String getGuaranty() {
        return guaranty;
    }

    public void setGuaranty(String guaranty) {
        this.guaranty = guaranty;
    }

    private String price;

    @javax.persistence.Column(name = "Price")
    @Basic
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreatmentsTranslationsVO that = (TreatmentsTranslationsVO) o;

        if (langId != that.langId) return false;
        if (treatmentId != that.treatmentId) return false;
        if (guaranty != null ? !guaranty.equals(that.guaranty) : that.guaranty != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = treatmentId;
        result = 31 * result + langId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (guaranty != null ? guaranty.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    private LanguagesVO languagesByLangId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "LangId", referencedColumnName = "Id", nullable = false)
    public LanguagesVO getLanguagesByLangId() {
        return languagesByLangId;
    }

    public void setLanguagesByLangId(LanguagesVO languagesByLangId) {
        this.languagesByLangId = languagesByLangId;
    }

    private TreatmentsVO treatmentsByTreatmentId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "TreatmentId", referencedColumnName = "Id", nullable = false)
    public TreatmentsVO getTreatmentsByTreatmentId() {
        return treatmentsByTreatmentId;
    }

    public void setTreatmentsByTreatmentId(TreatmentsVO treatmentsByTreatmentId) {
        this.treatmentsByTreatmentId = treatmentsByTreatmentId;
    }
}
