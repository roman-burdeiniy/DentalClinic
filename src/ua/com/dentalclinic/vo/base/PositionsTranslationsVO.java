package ua.com.dentalclinic.vo.base;

import ua.com.dentalclinic.vo.TranslationVO;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 4/11/14
 * Time: 1:44 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.IdClass(PositionsTranslationsVOPK.class)
@javax.persistence.Table(name = "positions_translations", schema = "", catalog = "dentalclinicdb")
@Entity
public class PositionsTranslationsVO implements TranslationVO
{
    private int positionId;
    private String name;
    private int langId;


    @Id
    @Column(name = "PositionId", insertable = false, updatable = false)
    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int id) {
        this.positionId = id;
    }

    @javax.persistence.Column(name = "LangId", insertable = false, updatable = false)
    @Id
    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    @javax.persistence.Column(name = "Name")
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private LanguagesVO languagesByLangId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "LangId", referencedColumnName = "Id", nullable = false)
    public LanguagesVO getLanguagesByLangId() {
        return languagesByLangId;
    }

    public void setLanguagesByLangId(LanguagesVO languagesByLangId) {
        this.languagesByLangId = languagesByLangId;
    }

    private PositionsVO positionsByPositionId;

    @ManyToOne
    @javax.persistence.JoinColumn(name = "PositionId", referencedColumnName = "Id", nullable = false)
    public PositionsVO getPositionsByPositionId() {
        return positionsByPositionId;
    }

    public void setPositionsByPositionId(PositionsVO positionsByPositionId) {
        this.positionsByPositionId = positionsByPositionId;
    }
}
