package ua.com.dentalclinic.dto;

/**
 * Created by IntelliJ IDEA.
 * User: roman_b
 * Date: 10/17/13
 * Time: 5:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class TreatmentDTO {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String group;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    private String subGroup;

    public String getSubGroup() {
        return subGroup;
    }

    public void setSubGroup(String subGroup) {
        this.subGroup = subGroup;
    }


    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String description = "";

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    private String guaranty = "";

    public void setGuaranty(String guaranty)
    {
        this.guaranty = guaranty;
    }

    public String getGuaranty()
    {
        return this.guaranty;
    }
}
