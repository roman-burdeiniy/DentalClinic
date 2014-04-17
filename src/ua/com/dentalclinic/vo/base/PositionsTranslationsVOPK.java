package ua.com.dentalclinic.vo.base;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 4/10/14
 * Time: 2:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class PositionsTranslationsVOPK implements Serializable {

    private int positionId;
    private int langId;

    @Id
    @Column(name = "PositionId")
    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int id) {
        this.positionId = id;
    }

    @Id@Column(name = "LangId")
    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PositionsTranslationsVOPK that = (PositionsTranslationsVOPK) o;

        if (positionId != that.positionId) return false;
        if (langId != that.langId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = positionId;
        result = 31 * result + langId;
        return result;
    }
}
