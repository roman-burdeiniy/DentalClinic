package ua.com.dentalclinic.vo.base;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 12/30/13
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "appointments", schema = "", catalog = "dentalclinicdb")
@Entity
public class AppointmentsVO {
    private int id;
    private Timestamp preferredDateTime;
    private Timestamp actualDateTime;
    private String comments;
    private DoctorsVO doctorsByDoctorId;
    private PatientsVO patientsByPatientId;

    @javax.persistence.Column(name = "Id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @javax.persistence.Column(name = "PreferredDateTime")
    @Basic
    public Timestamp getPreferredDateTime() {
        return preferredDateTime;
    }

    public void setPreferredDateTime(Timestamp preferredDateTime) {
        this.preferredDateTime = preferredDateTime;
    }

    @javax.persistence.Column(name = "ActualDateTime")
    @Basic
    public Timestamp getActualDateTime() {
        return actualDateTime;
    }

    public void setActualDateTime(Timestamp actualDateTime) {
        this.actualDateTime = actualDateTime;
    }

    @javax.persistence.Column(name = "Comments")
    @Basic
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppointmentsVO that = (AppointmentsVO) o;

        if (id != that.id) return false;
        if (actualDateTime != null ? !actualDateTime.equals(that.actualDateTime) : that.actualDateTime != null)
            return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
        if (preferredDateTime != null ? !preferredDateTime.equals(that.preferredDateTime) : that.preferredDateTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (preferredDateTime != null ? preferredDateTime.hashCode() : 0);
        result = 31 * result + (actualDateTime != null ? actualDateTime.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @javax.persistence.JoinColumn(name = "DoctorId", referencedColumnName = "Id")
    public DoctorsVO getDoctorsByDoctorId() {
        return doctorsByDoctorId;
    }

    public void setDoctorsByDoctorId(DoctorsVO doctorsByDoctorId) {
        this.doctorsByDoctorId = doctorsByDoctorId;
    }

    @ManyToOne
    @javax.persistence.JoinColumn(name = "PatientId", referencedColumnName = "Id", nullable = false)
    public PatientsVO getPatientsByPatientId() {
        return patientsByPatientId;
    }

    public void setPatientsByPatientId(PatientsVO patientsByPatientId) {
        this.patientsByPatientId = patientsByPatientId;
    }
}
