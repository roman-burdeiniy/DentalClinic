package ua.com.dentalclinic.treatment;


import ua.com.dentalclinic.base.ServiceBase;
import ua.com.dentalclinic.vo.base.TreatmentsVO;

import javax.persistence.TypedQuery;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: roman_b
 * Date: 10/4/13
 * Time: 4:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class TreatmentsService extends ServiceBase {

    public TreatmentsService()
    {
        super();
    }

    public List<TreatmentsVO> getAllTreatments(int langId)
    {
        List<TreatmentsVO> results = em.createNamedQuery("TreatmentVO.getAllByLangId")
                .setParameter("langId", langId)
                .getResultList();
        return results;
    }

    public List<TreatmentsVO> getTreatmentsByCategoryAndLang(String[] catIds, int langId)
    {
        List<TreatmentsVO> results = em.createNamedQuery("TreatmentVO.getTreatmentsByCatIdAndLangId")
            .setParameter("catIds", Arrays.asList(catIds))
            .setParameter("langId", langId)
            .getResultList();
        return results;
    }

    public List<TreatmentsVO> getCategoryTreatments(int langId)
    {
        List<TreatmentsVO> results = em.createNamedQuery("TreatmentVO.getAllCategoryTreatmentsByLangId")
                .setParameter("langId", langId)
                .getResultList();
        return results;
    }

    public int insertTreatment(TreatmentsVO item)
    {
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
        return item.getId();
    }
}
