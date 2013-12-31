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
@javax.persistence.IdClass(ua.com.dentalclinic.vo.base.DoctorsTranslationsVOPK.class)
@javax.persistence.Table(name = "doctors_translations", schema = "", catalog = "dentalclinicdb")
@Entity
public class DoctorsTranslationsVO {
    private int doctorId;
    private int langId;
    private String firstName;
    private String lastName;
    private String speciality;
    private String education;
    private LanguagesVO languagesByLangId;
    private DoctorsVO doctorsByDoctorId;

    @javax.persistence.Column(name = "DoctorId", insertable = false, updatable = false)
    @Id
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    @javax.persistence.Column(name = "LangId", insertable = false, updatable = false)
    @Id
    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    @javax.persistence.Column(name = "FirstName")
    @Basic
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @javax.persistence.Column(name = "LastName")
    @Basic
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @javax.persistence.Column(name = "Speciality")
    @Basic
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @javax.persistence.Column(name = "Education")
    @Basic
    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DoctorsTranslationsVO that = (DoctorsTranslationsVO) o;

        if (doctorId != that.doctorId) return false;
        if (langId != that.langId) return false;
        if (education != null ? !education.equals(that.education) : that.education != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (speciality != null ? !speciality.equals(that.speciality) : that.speciality != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = doctorId;
        result = 31 * result + langId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (speciality != null ? speciality.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
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
    @javax.persistence.JoinColumn(name = "DoctorId", referencedColumnName = "Id", nullable = false)
    public DoctorsVO getDoctorsByDoctorId() {
        return doctorsByDoctorId;
    }

    public void setDoctorsByDoctorId(DoctorsVO doctorsByDoctorId) {
        this.doctorsByDoctorId = doctorsByDoctorId;
    }
}
