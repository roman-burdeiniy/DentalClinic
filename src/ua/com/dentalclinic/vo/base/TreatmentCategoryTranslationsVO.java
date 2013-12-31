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
@javax.persistence.IdClass(ua.com.dentalclinic.vo.base.TreatmentCategoryTranslationsVOPK.class)
@javax.persistence.Table(name = "treatment_category_translations", schema = "", catalog = "dentalclinicdb")
@Entity
public class TreatmentCategoryTranslationsVO {
    private int categoryId;
    private int langId;
    private String name;
    private LanguagesVO languagesByLangId;
    private TreatmentCategoryVO treatmentCategoryByCategoryId;

    @javax.persistence.Column(name = "CategoryId", insertable = false, updatable = false)
    @Id
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @javax.persistence.Column(name = "LangId", insertable = false, updatable = false)
    @Id
    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
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

        TreatmentCategoryTranslationsVO that = (TreatmentCategoryTranslationsVO) o;

        if (categoryId != that.categoryId) return false;
        if (langId != that.langId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryId;
        result = 31 * result + langId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @javax.persistence.JoinColumn(name = "LangId", referencedColumnName = "Id", nullable = false)
    public LanguagesVO getLanguagesByLangId() {
        return languagesByLangId;
    }

    public void setLanguagesByLangId(LanguagesVO languagesByLangId) {
        this.languagesByLangId = languagesByLangId;
    }

    @ManyToOne
    @javax.persistence.JoinColumn(name = "CategoryId", referencedColumnName = "Id", nullable = false)
    public TreatmentCategoryVO getTreatmentCategoryByCategoryId() {
        return treatmentCategoryByCategoryId;
    }

    public void setTreatmentCategoryByCategoryId(TreatmentCategoryVO treatmentCategoryByCategoryId) {
        this.treatmentCategoryByCategoryId = treatmentCategoryByCategoryId;
    }
}
