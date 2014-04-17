package ua.com.dentalclinic.staff;

import org.json.JSONException;
import org.json.JSONObject;
import ua.com.dentalclinic.base.BaseServlet;
import ua.com.dentalclinic.language.LanguageModel;
import ua.com.dentalclinic.treatment.TreatmentJSONBuilder;
import ua.com.dentalclinic.treatment.TreatmentsController;
import ua.com.dentalclinic.treatment.TreatmentsService;
import ua.com.dentalclinic.vo.base.PositionsVO;
import ua.com.dentalclinic.vo.base.StaffTranslationsVO;
import ua.com.dentalclinic.vo.base.StaffVO;
import ua.com.dentalclinic.vo.base.TreatmentsVO;
import java.util.Arrays;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 4/2/14
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class StaffServlet extends BaseServlet {

    @Inject
    private StaffService service;

    @Inject
    public StaffJSONBuilder jsonResponseBuilder;

    @Inject
    public StaffVOBuilder staffBuilder;

    @Override
    protected void handlePost(HttpServletRequest req, HttpServletResponse resp) throws JSONException, IOException
    {
        int langId = LanguageModel.CURRENT_LANGUAGE.getId();
        String actionName = req.getParameter("actionName");
        if ("loadPositions".equals(actionName))
        {
            Collection<PositionsVO> positions = service.getAllPositions(langId);
            resp.getWriter().print(jsonResponseBuilder.buildPositions(positions));

        }else if ("loadStaffByPositions".equals(actionName))
        {
            Collection<StaffVO> staff = service.getAllStaff(langId);
            resp.getWriter().print(jsonResponseBuilder.buildStaff(staff, langId));

        }else if ("addEmployee".equals(actionName))
        {
            StaffVO staff = staffBuilder.buildFromRequest(req);
            StaffTranslationsVO tr = staffBuilder.buildTranslationFromRequest(req, langId);
            tr.setStaffByDoctorId(staff);
            staff.setStaffTranslationsesById(Arrays.asList(tr));
            int addedId = service.insertEmployee(staff);
            resp.getWriter().print(jsonResponseBuilder.buildId(req, addedId));
        }else if ("removeEmployee".equals(actionName))
        {
            int removedId = service.removeEmployee(Integer.parseInt(req.getParameter("id")));
            resp.getWriter().print(jsonResponseBuilder.buildId(req, removedId));
        }
    }


}
