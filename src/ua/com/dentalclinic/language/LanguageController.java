package ua.com.dentalclinic.language;


import ua.com.dentalclinic.vo.base.LanguagesVO;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: roman_b
 * Date: 10/29/13
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
public class LanguageController {

    @Inject
    private LanguageService service;

    private LanguageModel model = new LanguageModel();

    public void getAllLanguages()
    {
        List<LanguagesVO> result = service.getAllLanguages();
        model.setLanguages(result);
    }
}
