package ua.com.dentalclinic.staff;

import ua.com.dentalclinic.base.ServiceBase;
import ua.com.dentalclinic.vo.base.PositionsVO;
import ua.com.dentalclinic.vo.base.StaffTranslationsVO;
import ua.com.dentalclinic.vo.base.StaffVO;

import javax.ejb.*;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 4/2/14
 * Time: 4:39 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class StaffService extends ServiceBase {

    public StaffService()
    {
        super();
    }

    @TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
    public List<StaffVO> getAllStaff(int langId)
    {
        List<StaffVO> results = em.createNamedQuery("StaffVO.getAllByLangId")
                .setParameter("langId", langId)
                .getResultList();
        return results;
    }

    public List<PositionsVO> getAllPositions(int langId)
    {
        List<PositionsVO> results = em.createNamedQuery("PositionsVO.getAllByLangId")
                .setParameter("langId", langId)
                .getResultList();
        return results;
    }

    @TransactionAttribute(value = TransactionAttributeType.REQUIRES_NEW)
    public int insertEmployee(StaffVO item)
    {
        PositionsVO position = em.find(PositionsVO.class, item.getPositionId());
        item.setPositionById(position);
        em.persist(item);
        return item.getId();
    }

    public int removeEmployee(int id)
    {
        StaffVO toDelete = em.find(StaffVO.class, id);
        em.remove(toDelete);
        return id;
    }
}
