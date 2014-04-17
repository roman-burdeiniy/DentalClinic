package ua.com.dentalclinic.treatment;

/**
 * Created by IntelliJ IDEA.
 * User: roman_b
 * Date: 10/3/13
 * Time: 6:42 PM
 * To change this template use File | Settings | File Templates.
 */

import com.google.gson.*;
import org.json.JSONException;
import org.json.JSONObject;
import ua.com.dentalclinic.dto.TreatmentDTO;
import ua.com.dentalclinic.language.LanguageController;
import ua.com.dentalclinic.vo.base.TreatmentsVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PriceManagerServlet extends BasePriceServlet {


    @Override
    protected void handlePost(HttpServletRequest req, HttpServletResponse resp) throws JSONException, IOException
    {
        super.handlePost(req, resp);
        String actionName = req.getParameter("actionName");
        if ("addCategory".equals(actionName))
        {
            String name = req.getParameter("categoryName");
           // int id = controller.insertCategory(name);
           // resp.getWriter().print(jsonResponseBuilder.buildCategory(id, name));

        }
    }
}
