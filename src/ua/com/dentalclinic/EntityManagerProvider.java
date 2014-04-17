package ua.com.dentalclinic;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Scope;
import javax.persistence.*;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: roman_b
 * Date: 10/8/13
 * Time: 3:26 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateful
public class EntityManagerProvider implements Serializable {

    @PersistenceContext(unitName = "persistenceUnit")
    private EntityManager em;

    @Produces
    public EntityManager getEntityManager() {
        return em;
    }

}
