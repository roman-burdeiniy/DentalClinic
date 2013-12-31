package ua.com.dentalclinic.treatment;

import ua.com.dentalclinic.dataBaseConnection.DentalClinicConnection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: roman_b
 * Date: 10/4/13
 * Time: 4:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class TreatmentsDataProvider {

    private DataSource dataSource;

    public  TreatmentsDataProvider()
    {
       
    }
    
    public ResultSet getAllTreatments(Integer langId) throws SQLException
    {
        ResultSet result = null;

        Connection connection = null;
        try{
            Connection connection1 = connection = DentalClinicConnection.getConnection();
            CallableStatement cs = connection.prepareCall("{call get_all_treatments(?)}");
            cs.setInt("lang_id", langId);
            result = cs.executeQuery();
          }
          catch (SQLException e) {
              e.printStackTrace();
          }
        finally
          {
              try { if(result != null)result.close();} catch (SQLException e)
              {e.printStackTrace();}
              try { if(connection != null)connection.close();} catch (SQLException e)
              {e.printStackTrace();}
            return result;
          }
    }
}
