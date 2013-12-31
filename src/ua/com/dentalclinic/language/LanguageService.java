package ua.com.dentalclinic.language;


import ua.com.dentalclinic.base.ServiceBase;
import ua.com.dentalclinic.vo.base.LanguagesVO;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: roman_b
 * Date: 10/29/13
 * Time: 4:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class LanguageService extends ServiceBase {


    public List<LanguagesVO> getAllLanguages()
    {
        TypedQuery<LanguagesVO> query =
                em.createNamedQuery("LanguagesVO.getAll", LanguagesVO.class);
        List<LanguagesVO> results = query.getResultList();
        return  results;
    }
}
