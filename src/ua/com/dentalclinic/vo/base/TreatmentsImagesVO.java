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
@javax.persistence.Table(name = "treatments_images", schema = "", catalog = "dentalclinicdb")
@Entity
public class TreatmentsImagesVO {
    private int id;

    @javax.persistence.Column(name = "Id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;

    @javax.persistence.Column(name = "Name")
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String url;

    @javax.persistence.Column(name = "Url")
    @Basic
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreatmentsImagesVO that = (TreatmentsImagesVO) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    private TreatmentsVO treatmentsByTreatmentId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "TreatmentId", referencedColumnName = "Id", nullable = false)
    public TreatmentsVO getTreatmentsByTreatmentId() {
        return treatmentsByTreatmentId;
    }

    public void setTreatmentsByTreatmentId(TreatmentsVO treatmentsByTreatmentId) {
        this.treatmentsByTreatmentId = treatmentsByTreatmentId;
    }
}
