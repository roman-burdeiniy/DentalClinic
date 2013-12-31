package ua.com.dentalclinic.vo.base;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 12/30/13
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class TreatmentCategoryTranslationsVOPK implements Serializable {
    private int categoryId;
    private int langId;

@Id@Column(name = "CategoryId" , insertable = false, updatable = false)
public int getCategoryId() {
    return categoryId;
}

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Id@Column(name = "LangId" , insertable = false, updatable = false)
    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreatmentCategoryTranslationsVOPK that = (TreatmentCategoryTranslationsVOPK) o;

        if (categoryId != that.categoryId) return false;
        if (langId != that.langId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryId;
        result = 31 * result + langId;
        return result;
}}
