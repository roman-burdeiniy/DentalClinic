package ua.com.dentalclinic.treatment;


import ua.com.dentalclinic.base.ServiceBase;
import ua.com.dentalclinic.vo.base.TreatmentCategoryVO;
import ua.com.dentalclinic.vo.base.TreatmentsVO;

import javax.persistence.EntityManager;
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

    public List<TreatmentsVO> getAllTreatments(int langId)
    {
        List<TreatmentsVO> results = (List<TreatmentsVO>)getItems("TreatmentsVO.getAllByLangId", langId);
        return  results;
    }

    public List<TreatmentsVO> getTreatmentsByCategoryAndLang(String[] catIds, int langId)
    {
       // initEntityManager();
        List<TreatmentsVO> results;
        if (catIds != null && catIds.length > 0)
        {
            results = em.createNamedQuery("TreatmentVO.getTreatmentsByCatIdAndLangId")
                    .setParameter("catIds", Arrays.asList(catIds))
                    .setParameter("langId", langId)
                    .getResultList();
        }
        else
        {
            results = em.createNamedQuery("TreatmentVO.getNonCatigorized")
                    .setParameter("langId", langId)
                    .getResultList();
        }

       // em.close();
        return results;
    }

    public List<TreatmentCategoryVO> getAllCategoriesByLang(int langId)
    {
        TypedQuery<TreatmentCategoryVO> query =
                em.createNamedQuery("TreatmentCategoryVO.getAllByLangId", TreatmentCategoryVO.class)
                .setParameter("langId", langId);
        List<TreatmentCategoryVO> results = query.getResultList();
        return  results;
    }

    public int insertCategory(TreatmentCategoryVO item)
    {
        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
        return item.getId();
    }

    public int insertTreatment(TreatmentsVO item)
    {

        em.getTransaction().begin();
        em.persist(item);
        em.getTransaction().commit();
        return item.getId();
    }
}
