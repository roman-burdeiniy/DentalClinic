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
@javax.persistence.Table(name = "languages", schema = "", catalog = "dentalclinicdb")
@Entity
@NamedQueries({
        @NamedQuery(name="LanguagesVO.getAll", query="SELECT l FROM LanguagesVO l")
})
public class LanguagesVO {
    private int id;
    private String code;
    private Collection<DoctorsTranslationsVO> doctorsTranslationsesById;
    private Collection<TreatmentsTranslationsVO> treatmentsTranslationsesById;

    @javax.persistence.Column(name = "Id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @javax.persistence.Column(name = "Code")
    @Basic
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LanguagesVO that = (LanguagesVO) o;

        if (id != that.id) return false;
        if (code != null ? !code.equals(that.code) : that.code != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "languagesByLangId")
    public Collection<DoctorsTranslationsVO> getDoctorsTranslationsesById() {
        return doctorsTranslationsesById;
    }

    public void setDoctorsTranslationsesById(Collection<DoctorsTranslationsVO> doctorsTranslationsesById) {
        this.doctorsTranslationsesById = doctorsTranslationsesById;
    }

    @OneToMany(mappedBy = "languagesByLangId")
    public Collection<TreatmentsTranslationsVO> getTreatmentsTranslationsesById() {
        return treatmentsTranslationsesById;
    }

    public void setTreatmentsTranslationsesById(Collection<TreatmentsTranslationsVO> treatmentsTranslationsesById) {
        this.treatmentsTranslationsesById = treatmentsTranslationsesById;
    }
}
