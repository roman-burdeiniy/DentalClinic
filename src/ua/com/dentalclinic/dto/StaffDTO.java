package ua.com.dentalclinic.dto;

/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 4/11/14
 * Time: 11:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class StaffDTO {
    private int id;
    private String name;
    private String position;
    private String speciality;
    private String gender;
    private String mobNumber;
    private String education;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(String mobNumber) {
        this.mobNumber = mobNumber;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}
