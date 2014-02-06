package ua.com.dentalclinic.treatment;

import org.json.JSONException;
import org.json.JSONObject;
import ua.com.dentalclinic.dto.TreatmentCategoryDTO;
import ua.com.dentalclinic.dto.TreatmentDTO;
import ua.com.dentalclinic.vo.base.TreatmentsTranslationsVO;
import ua.com.dentalclinic.vo.base.TreatmentsVO;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 1/21/14
 * Time: 5:09 PM
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@RequestScoped
public class TreatmentJSONBuilder {

   public JSONObject buildCategories(Collection<TreatmentsVO> categories) throws JSONException
    {
        JSONObject result = new JSONObject();
        ArrayList categoriesToSend = new ArrayList();
        for (TreatmentsVO category : categories)
        {
            TreatmentCategoryDTO catToAdd = new TreatmentCategoryDTO();
            catToAdd.setId(category.getId());
            Collection<TreatmentsTranslationsVO> translations = category.getTreatmentsTranslationsesById();
            TreatmentsTranslationsVO translation = (TreatmentsTranslationsVO)translations.toArray()[0];
            catToAdd.setName(translation.getName());
            categoriesToSend.add(catToAdd);
        }
        if (categoriesToSend.size() > 0)
        {
            result.put("categories", categoriesToSend);
        }
        return result;
    }

    public JSONObject buildCategory(int id, String name) throws JSONException
    {
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("categoryId", id);
        jsonResponse.put("categoryName", name);
        return jsonResponse;
    }

    public JSONObject buildTreatments(Collection<TreatmentsVO> treatments) throws JSONException
    {
        JSONObject result = new JSONObject();
        ArrayList treatmentsToSend = new ArrayList();
        if (treatments == null)
            return result.put("prices", new TreatmentDTO[0]);

        for (TreatmentsVO treatment : treatments)
        {
            TreatmentDTO treatmentToAdd = new TreatmentDTO();

            if (isNotSubGroup(treatment))
            {
                treatmentToAdd.setGroup(getLastParentName(treatment, false));
                treatmentToAdd.setSubGroup(getLastParentName(treatment, true));
                treatmentToAdd.setId(treatment.getId());

                Collection<TreatmentsTranslationsVO> translations = treatment.getTreatmentsTranslationsesById();
                TreatmentsTranslationsVO translation = (TreatmentsTranslationsVO)translations.toArray()[0];
                treatmentToAdd.setName(translation.getName());
                treatmentToAdd.setPrice(translation.getPrice());
                treatmentToAdd.setDescription(translation.getDescription() == null ? "" : translation.getDescription());
                treatmentToAdd.setGuaranty(translation.getGuaranty().equals("null") ? "" : translation.getGuaranty());
                treatmentsToSend.add(treatmentToAdd);
            }

        }
        result.put("prices", treatmentsToSend);
        return result;
    }

    private Boolean isNotSubGroup(TreatmentsVO treatment)
    {
        TreatmentsVO parent = treatment.getTreatmentsByParentTreatmentId();
        TreatmentsVO parentParent = parent != null ? parent.getTreatmentsByParentTreatmentId() : null;
        return  parent != null && parentParent != null;
    }

    private String getLastParentName(TreatmentsVO treatment, Boolean firstFound)
    {
        TreatmentsVO parent = treatment.getTreatmentsByParentTreatmentId();
        if (firstFound && parent != null)
        {
            return ((TreatmentsTranslationsVO)parent.getTreatmentsTranslationsesById().toArray()[0]).getName();
        }
         return parent != null ? getLastParentName(parent, false) :
                 ((TreatmentsTranslationsVO)treatment.getTreatmentsTranslationsesById().toArray()[0]).getName();
    }

    private String getParentParentName(TreatmentsVO treatment)
    {
        TreatmentsVO parent = treatment.getTreatmentsByParentTreatmentId();
        TreatmentsVO parentParent = parent.getTreatmentsByParentTreatmentId();
        String name = ((TreatmentsTranslationsVO)parentParent.getTreatmentsTranslationsesById().toArray()[0]).getName();
        return name;
    }

    private void setGroup(Collection<TreatmentsVO> children)
    {

    }

    private void setSubGroup(Collection<TreatmentsVO> children)
    {

    }
}
