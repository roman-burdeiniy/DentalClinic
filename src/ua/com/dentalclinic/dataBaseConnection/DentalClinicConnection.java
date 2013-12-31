package ua.com.dentalclinic.dataBaseConnection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: roman_b
 * Date: 10/4/13
 * Time: 5:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class DentalClinicConnection {

    private static DataSource dataSource;

    static {
        try {
            Context initContext  = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            dataSource = (DataSource)envContext.lookup("jdbc/dentalclinicdb");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    private DentalClinicConnection() {
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
