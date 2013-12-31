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
@javax.persistence.Table(name = "patients", schema = "", catalog = "dentalclinicdb")
@Entity
public class PatientsVO {
    private int id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String phoneNumber;
    private Boolean visitedBefore;
    private Collection<AppointmentsVO> appointmentsesById;

    @javax.persistence.Column(name = "Id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @javax.persistence.Column(name = "PhoneNumber")
    @Basic
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @javax.persistence.Column(name = "VisitedBefore")
    @Basic
    public Boolean getVisitedBefore() {
        return visitedBefore;
    }

    public void setVisitedBefore(Boolean visitedBefore) {
        this.visitedBefore = visitedBefore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatientsVO that = (PatientsVO) o;

        if (id != that.id) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(that.dateOfBirth) : that.dateOfBirth != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (visitedBefore != null ? !visitedBefore.equals(that.visitedBefore) : that.visitedBefore != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (visitedBefore != null ? visitedBefore.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "patientsByPatientId")
    public Collection<AppointmentsVO> getAppointmentsesById() {
        return appointmentsesById;
    }

    public void setAppointmentsesById(Collection<AppointmentsVO> appointmentsesById) {
        this.appointmentsesById = appointmentsesById;
    }
}
