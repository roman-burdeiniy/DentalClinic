package ua.com.dentalclinic.vo.base;

/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 4/2/14
 * Time: 4:13 PM
 * To change this template use File | Settings | File Templates.
 */

import javax.persistence.*;
import java.util.Collection;

@javax.persistence.Table(name = "positions", schema = "", catalog = "dentalclinicdb")
@Entity
@NamedQueries({
        @NamedQuery(name="PositionsVO.getAllByLangId", query="SELECT p FROM PositionsVO p JOIN " +
                "p.positionsTranslationsesById ptr WHERE ptr.langId = :langId")
})
public class PositionsVO {

    private int id;
    private String name;


    @javax.persistence.Column(name = "Id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @javax.persistence.Column(name = "Name")
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Collection<PositionsTranslationsVO> positionsTranslationsesById;

    @OneToMany(mappedBy = "positionsByPositionId", cascade = CascadeType.PERSIST)
    public Collection<PositionsTranslationsVO> getPositionsTranslationsesById() {
        return positionsTranslationsesById;
    }

    public void setPositionsTranslationsesById(Collection<PositionsTranslationsVO> positionsTranslationsesById) {
        this.positionsTranslationsesById = positionsTranslationsesById;
    }

}
