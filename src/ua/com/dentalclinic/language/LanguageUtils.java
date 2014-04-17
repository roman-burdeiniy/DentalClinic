package ua.com.dentalclinic.language;

import ua.com.dentalclinic.vo.TranslationVO;

import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 11/22/13
 * Time: 1:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class LanguageUtils {

    public static <T extends TranslationVO> T getTranslation(Collection<? extends TranslationVO> translations, int langId)
    {
        if (translations == null)
            return null;
        for (TranslationVO translation : translations)
        {
            if (translation.getLangId() == langId)
                return (T)translation;
        }
        return null;
    }

}
