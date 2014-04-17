package ua.com.dentalclinic.vo.base;

import ua.com.dentalclinic.vo.TranslationVO;
import ua.com.dentalclinic.vo.base.StaffTranslationsVO;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 4/2/14
 * Time: 4:09 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "staff", schema = "", catalog = "dentalclinicdb")
@Entity
@NamedQueries({
        @NamedQuery(name="StaffVO.getAllByLangId", query="SELECT s FROM StaffVO s JOIN " +
                "s.staffTranslationsesById st JOIN s.positionById pos JOIN " +
                "s.positionById.positionsTranslationsesById posTr WHERE st.langId = :langId AND posTr.langId = :langId")
})
public class StaffVO {
    private int id;

    @javax.persistence.Column(name = "Id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Date dateOfBirth;

    @javax.persistence.Column(name = "DateOfBirth")
    @Basic
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    private String gender;

    @javax.persistence.Column(name = "Gender")
    @Basic
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String mobNumber;

    @javax.persistence.Column(name = "MobNumber")
    @Basic
    public String getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(String mobNumber) {
        this.mobNumber = mobNumber;
    }

    private String homeNumber;

    @javax.persistence.Column(name = "HomeNumber")
    @Basic
    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    private Byte yearsOfExperience;

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

        StaffVO staffVO = (StaffVO) o;

        if (id != staffVO.id) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(staffVO.dateOfBirth) : staffVO.dateOfBirth != null) return false;
        if (gender != null ? !gender.equals(staffVO.gender) : staffVO.gender != null) return false;
        if (homeNumber != null ? !homeNumber.equals(staffVO.homeNumber) : staffVO.homeNumber != null) return false;
        if (mobNumber != null ? !mobNumber.equals(staffVO.mobNumber) : staffVO.mobNumber != null) return false;
        if (yearsOfExperience != null ? !yearsOfExperience.equals(staffVO.yearsOfExperience) : staffVO.yearsOfExperience != null)
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

    private Collection<AppointmentsVO> appointmentsesById;

    @OneToMany(mappedBy = "staffByDoctorId")
    public Collection<AppointmentsVO> getAppointmentsesById() {
        return appointmentsesById;
    }

    public void setAppointmentsesById(Collection<AppointmentsVO> appointmentsesById) {
        this.appointmentsesById = appointmentsesById;
    }

    private int positionId;

    @javax.persistence.Column(name = "PositionId", insertable = false, updatable = false)
    @Basic
    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    private Collection<StaffTranslationsVO> staffTranslationsesById;

    @OneToMany(mappedBy = "staffByDoctorId", cascade = CascadeType.PERSIST)
    public Collection<StaffTranslationsVO> getStaffTranslationsesById() {
        return staffTranslationsesById;
    }

    public void setStaffTranslationsesById(Collection<StaffTranslationsVO> staffTranslationsesById) {
        this.staffTranslationsesById = staffTranslationsesById;
    }

    private Collection<WorkingHoursVO> workingHoursesById;

    @OneToMany(mappedBy = "staffByDoctorId")
    public Collection<WorkingHoursVO> getWorkingHoursesById() {
        return workingHoursesById;
    }

    public void setWorkingHoursesById(Collection<WorkingHoursVO> workingHoursesById) {
        this.workingHoursesById = workingHoursesById;
    }

    public void setPositionById(PositionsVO position) {
        this.position = position;
    }

    private PositionsVO position;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "PositionId", referencedColumnName = "Id")
    public PositionsVO getPositionById() {
        return this.position;
    }
}
