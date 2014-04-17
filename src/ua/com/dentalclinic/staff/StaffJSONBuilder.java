package ua.com.dentalclinic.staff;

import org.json.JSONException;
import org.json.JSONObject;
import ua.com.dentalclinic.dto.PositionDTO;
import ua.com.dentalclinic.dto.StaffDTO;
import ua.com.dentalclinic.language.LanguageUtils;
import ua.com.dentalclinic.vo.TranslationVO;
import ua.com.dentalclinic.vo.base.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 4/2/14
 * Time: 5:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class StaffJSONBuilder {

    public JSONObject buildPositions(Collection<PositionsVO> positions) throws JSONException
    {
        JSONObject result = new JSONObject();
        ArrayList positionsToSend = new ArrayList();
        for (PositionsVO position : positions)
        {
            PositionDTO posToAdd = new PositionDTO();
            posToAdd.setId(position.getId());
            posToAdd.setName(position.getName());
            positionsToSend.add(posToAdd);
        }
        if (positionsToSend.size() > 0)
        {
            result.put("data", positionsToSend);
        }
        return result;
    }

    public JSONObject buildStaff(Collection<StaffVO> staff, int langId) throws JSONException
    {
        JSONObject result = new JSONObject();
        ArrayList staffToSend = new ArrayList();
        for (StaffVO staffItem : staff)
        {
            StaffDTO staffToAdd = new StaffDTO();
            staffToAdd.setId(staffItem.getId());
            StaffTranslationsVO tr = LanguageUtils.getTranslation(staffItem.getStaffTranslationsesById(), langId);
            staffToAdd.setName(tr.getLastName() + tr.getFirstName() + tr.getMiddleName());
            staffToAdd.setEducation(tr.getEducation());
            staffToAdd.setMobNumber(staffItem.getMobNumber());
            staffToAdd.setGender(staffItem.getGender());
            staffToAdd.setSpeciality(tr.getSpeciality());
            PositionsVO pos = staffItem.getPositionById();
            Collection<PositionsTranslationsVO> posTrs = pos.getPositionsTranslationsesById();
            PositionsTranslationsVO posTr = LanguageUtils.getTranslation(posTrs, langId);
            staffToAdd.setPosition(posTr.getName());

            staffToSend.add(staffToAdd);
        }
        if (staffToSend.size() > 0)
        {
            result.put("data", staffToSend);
        }
        return result;
    }

    public JSONObject buildId(HttpServletRequest req, int id) throws JSONException
    {
        JSONObject result = new JSONObject();
        result.put("id", id);
        return result;
    }
}
