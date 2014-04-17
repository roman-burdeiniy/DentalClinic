package ua.com.dentalclinic.treatment;

import org.json.JSONException;
import ua.com.dentalclinic.base.BaseServlet;
import ua.com.dentalclinic.vo.base.TreatmentsVO;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 3/27/14
 * Time: 3:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class BasePriceServlet extends BaseServlet {

    @Inject
    public TreatmentsController controller;
    @Inject
    public TreatmentJSONBuilder jsonResponseBuilder;

    @Override
    protected void handlePost(HttpServletRequest req, HttpServletResponse resp) throws JSONException, IOException
    {
        String actionName = req.getParameter("actionName");
        if ("loadCategories".equals(actionName))
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
}
