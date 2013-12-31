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
public class TreatmentsTranslationsVOPK implements Serializable {
    private int treatmentId;
    private int langId;

@Id@Column(name = "TreatmentId", insertable = false, updatable = false)
public int getTreatmentId() {
    return treatmentId;
}

    public void setTreatmentId(int treatmentId) {
        this.treatmentId = treatmentId;
    }

    @Id@Column(name = "LangId", insertable = false, updatable = false)
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

        TreatmentsTranslationsVOPK that = (TreatmentsTranslationsVOPK) o;

        if (langId != that.langId) return false;
        if (treatmentId != that.treatmentId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = treatmentId;
        result = 31 * result + langId;
        return result;
}}
