package ua.com.dentalclinic.vo.base;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 12/30/13
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "doctors", schema = "", catalog = "dentalclinicdb")
@Entity
public class DoctorsVO {
    private int id;
    private Date dateOfBirth;
    private String gender;
    private String mobNumber;
    private String homeNumber;
    private Byte yearsOfExperience;
    private Collection<AppointmentsVO> appointmentsesById;
    private Collection<DoctorsTranslationsVO> doctorsTranslationsesById;
    private Collection<WorkingHoursVO> workingHoursesById;

    @javax.persistence.Column(name = "Id")
    @Id
    public int getId() {
        return id;
    }

   public void setId(int id) {
        this.id = id;
    }

    @javax.persistence.Column(name = "DateOfBirth")
    @Basic
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @javax.persistence.Column(name = "Gender")
    @Basic
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @javax.persistence.Column(name = "MobNumber")
    @Basic
    public String getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(String mobNumber) {
        this.mobNumber = mobNumber;
    }

    @javax.persistence.Column(name = "HomeNumber")
    @Basic
    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    @javax.persistence.Column(name = "YearsOfExperience")
    @Basic
    public Byte getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Byte yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DoctorsVO doctorsVO = (DoctorsVO) o;

        if (id != doctorsVO.id) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(doctorsVO.dateOfBirth) : doctorsVO.dateOfBirth != null)
            return false;
        if (gender != null ? !gender.equals(doctorsVO.gender) : doctorsVO.gender != null) return false;
        if (homeNumber != null ? !homeNumber.equals(doctorsVO.homeNumber) : doctorsVO.homeNumber != null) return false;
        if (mobNumber != null ? !mobNumber.equals(doctorsVO.mobNumber) : doctorsVO.mobNumber != null) return false;
        if (yearsOfExperience != null ? !yearsOfExperience.equals(doctorsVO.yearsOfExperience) : doctorsVO.yearsOfExperience != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (mobNumber != null ? mobNumber.hashCode() : 0);
        result = 31 * result + (homeNumber != null ? homeNumber.hashCode() : 0);
        result = 31 * result + (yearsOfExperience != null ? yearsOfExperience.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "doctorsByDoctorId")
    public Collection<AppointmentsVO> getAppointmentsesById() {
        return appointmentsesById;
    }

    public void setAppointmentsesById(Collection<AppointmentsVO> appointmentsesById) {
        this.appointmentsesById = appointmentsesById;
    }

    @OneToMany(mappedBy = "doctorsByDoctorId")
    public Collection<DoctorsTranslationsVO> getDoctorsTranslationsesById() {
        return doctorsTranslationsesById;
    }

    public void setDoctorsTranslationsesById(Collection<DoctorsTranslationsVO> doctorsTranslationsesById) {
        this.doctorsTranslationsesById = doctorsTranslationsesById;
    }

    @OneToMany(mappedBy = "doctorsByDoctorId")
    public Collection<WorkingHoursVO> getWorkingHoursesById() {
        return workingHoursesById;
    }

    public void setWorkingHoursesById(Collection<WorkingHoursVO> workingHoursesById) {
        this.workingHoursesById = workingHoursesById;
    }
}
