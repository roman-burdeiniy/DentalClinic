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

public class TreatmentServlet extends javax.servlet.http.HttpServlet {

    @Inject
    public TreatmentsController controller;
    @Inject
    public TreatmentJSONBuilder jsonResponseBuilder;

    private LanguageController langController = new LanguageController();

    public void init() throws ServletException {
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
            resp.getWriter().print(e.getMessage());
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        String sEcho = req.getParameter("sEcho");

        try {
            JSONObject jsonResponse = new JSONObject();

            jsonResponse.put("sEcho", sEcho);
            jsonResponse.put("iTotalRecords", 5);
            jsonResponse.put("iTotalDisplayRecords", 5);

            ArrayList treatments = new ArrayList();
            for (Integer i = 0; i < 5; i++)
            {
                ArrayList row = new ArrayList();
                TreatmentDTO tr = new TreatmentDTO();
                if (i < 2)
                {
                    tr.setGroup("Group1");
                }
                else
                {
                    tr.setGroup("Group1");
                }
                
                tr.setName("treatment " + i.toString());
                String description = i%2 == 0 ?  "big big treatment big big treatment big big treatment big big treatment big big treatment" + i.toString() + " description" : "short description";
                tr.setDescription(description);
                //tr.setLowPrice(100);
                //tr.setTopPrice(200);
                treatments.add(tr);
            }

            jsonResponse.put("aaData", treatments);
            resp.setContentType("application/Json");
            resp.getWriter().print(jsonResponse);
        } catch (JsonIOException e) {
            e.printStackTrace();
            resp.setContentType("text/html");
            resp.getWriter().print(e.getMessage());
        } catch (JSONException e)
        {
            e.printStackTrace();
            resp.setContentType("text/html");
            resp.getWriter().print(e.getMessage());
        }
    }

    private void handlePost(HttpServletRequest req, HttpServletResponse resp) throws JSONException, IOException
    {
        String actionName = req.getParameter("actionName");
        if ("addCategory".equals(actionName))
        {
            String name = req.getParameter("categoryName");
           // int id = controller.insertCategory(name);
           // resp.getWriter().print(jsonResponseBuilder.buildCategory(id, name));

        }else if ("loadCategories".equals(actionName))
        {
            Collection<TreatmentsVO> categories = controller.getAllCategories();
            resp.getWriter().print(jsonResponseBuilder.buildCategories(categories));

        }else if ("loadPricesByCategories".equals(actionName))
        {
            String[] categories = req.getParameter("categoryIds[]").split(",");
            Collection<TreatmentsVO> treatments = controller.getTreatmentsByCategories(categories);
            resp.getWriter().print(jsonResponseBuilder.buildTreatments(treatments));
        }
    }

    private void applyResponse(HttpServletResponse resp)
    {
        resp.setContentType("application/Json");
        resp.setCharacterEncoding("UTF-8");
    }
}
