package ua.com.dentalclinic.base;

import ua.com.dentalclinic.EntityManagerProvider;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: roman_b
 * Date: 10/8/13
 * Time: 3:45 PM
 * To change this template use File | Settings | File Templates.
 */
@Named
public class ServiceBase {

    @Inject
    public EntityManager em;

    protected List<?> getItems(String queryName, Object... params)
    {
        Query q = em.createNamedQuery(queryName);
        if (params != null)
        {
            for (int i = 0; i < params.length; i++)
            {
                q.setParameter(i + 1, params[i]);
            }
        }
        List<?> result = q.getResultList();
        return result;
    }
}
