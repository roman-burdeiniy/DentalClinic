package ua.com.dentalclinic;

import ua.com.dentalclinic.language.LanguageController;
import ua.com.dentalclinic.treatment.TreatmentsController;

import javax.inject.Inject;
import javax.persistence.*;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by IntelliJ IDEA.
 * User: roman_b
 * Date: 10/29/13
 * Time: 4:20 PM
 * To change this template use File | Settings | File Templates.
 */
@WebListener
public class ApplicationInitManager implements ServletContextListener {

    @Inject
    private LanguageController langController;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        langController.getAllLanguages();
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }
}
