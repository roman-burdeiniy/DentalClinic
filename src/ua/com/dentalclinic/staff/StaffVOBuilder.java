package ua.com.dentalclinic.staff;

import org.json.JSONObject;
import ua.com.dentalclinic.vo.base.StaffTranslationsVO;
import ua.com.dentalclinic.vo.base.StaffVO;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 4/2/14
 * Time: 5:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class StaffVOBuilder {

    public StaffVO buildFromRequest(HttpServletRequest req)
    {
        StaffVO result = new StaffVO();
        result.setPositionId(Integer.parseInt(req.getParameter("positionSelect")));
        result.setGender(req.getParameter("gender"));
        result.setMobNumber(req.getParameter("phoneNum"));
        return result;
    }

    public StaffTranslationsVO buildTranslationFromRequest(HttpServletRequest req, int langId)
    {
        StaffTranslationsVO translation = new StaffTranslationsVO();
        translation.setLangId(langId);
        translation.setFirstName(req.getParameter("firstName"));
        translation.setLastName(req.getParameter("lastName"));
        translation.setMiddleName(req.getParameter("middleName"));
        translation.setSpeciality(req.getParameter("speciality"));
        translation.setEducation(req.getParameter("education"));
        return translation;
    }
}
