package ua.com.dentalclinic.base;

import org.json.JSONException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 4/2/14
 * Time: 5:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class BaseServlet extends javax.servlet.http.HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        try
        {
            applyResponse(resp);
            handlePost(req, resp);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            resp.setContentType("text/html");
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            //resp.getOutputStream().print(stringWriter.toString());
            resp.getWriter().print(stringWriter.toString());
        }
    }

    protected void handlePost(HttpServletRequest req, HttpServletResponse resp) throws JSONException, IOException
    {

    }

    private void applyResponse(HttpServletResponse resp)
    {
        resp.setContentType("application/Json");
        resp.setCharacterEncoding("UTF-8");
    }
}
