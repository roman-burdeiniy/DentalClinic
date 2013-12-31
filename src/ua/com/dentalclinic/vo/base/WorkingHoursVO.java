package ua.com.dentalclinic.vo.base;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Time;

/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 12/30/13
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "working_hours", schema = "", catalog = "dentalclinicdb")
@Entity
public class WorkingHoursVO {
    private byte day;

    @javax.persistence.Column(name = "Day")
    @Basic
    public byte getDay() {
        return day;
    }

    public void setDay(byte day) {
        this.day = day;
    }

    private Time startTime;

    @javax.persistence.Column(name = "StartTime")
    @Basic
    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    private Time endTme;

    @javax.persistence.Column(name = "EndTme")
    @Basic
    public Time getEndTme() {
        return endTme;
    }

    public void setEndTme(Time endTme) {
        this.endTme = endTme;
    }

    private int id;

    @javax.persistence.Column(name = "Id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkingHoursVO that = (WorkingHoursVO) o;

        if (day != that.day) return false;
        if (id != that.id) return false;
        if (endTme != null ? !endTme.equals(that.endTme) : that.endTme != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) day;
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTme != null ? endTme.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }

    private DoctorsVO doctorsByDoctorId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "DoctorId", referencedColumnName = "Id", nullable = false)
    public DoctorsVO getDoctorsByDoctorId() {
        return doctorsByDoctorId;
    }

    public void setDoctorsByDoctorId(DoctorsVO doctorsByDoctorId) {
        this.doctorsByDoctorId = doctorsByDoctorId;
    }
}
