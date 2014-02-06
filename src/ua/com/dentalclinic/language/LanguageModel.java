package ua.com.dentalclinic.language;

import ua.com.dentalclinic.vo.ITranslationVO;
import ua.com.dentalclinic.vo.base.LanguagesVO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: roman_b
 * Date: 10/29/13
 * Time: 4:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class LanguageModel {
    
    public static LanguagesVO CURRENT_LANGUAGE;
    private final String DEFAULT_LANGUAGE = "uk_UA";

    public static final String[] codes = {
                                        "en_US", "ru_RU"
                                         };

    public List<LanguagesVO> getLanguages() {
        return languages;
    }

    public void setLanguages(List<LanguagesVO> languages) {
        this.languages = languages;
        setCurrentLanguage();
    }

    public void setCurrentLanguage()
    {
         for (LanguagesVO lang : languages)
         {
             if (DEFAULT_LANGUAGE.equals(lang.getCode()))
             {
                 CURRENT_LANGUAGE = lang;
                 break;
             }
         }
    }

    public ITranslationVO getCurrentTranslation(List<ITranslationVO> translations)
    {
        if (translations == null)
            return null;
        for (ITranslationVO translation : translations)
        {
             if (translation.getLangId() == CURRENT_LANGUAGE.getId())
                 return translation;
        }
        return null;
    }


    private List<LanguagesVO> languages;
}
