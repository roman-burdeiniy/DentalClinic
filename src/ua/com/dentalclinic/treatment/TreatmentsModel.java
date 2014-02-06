package ua.com.dentalclinic.treatment;


import ua.com.dentalclinic.language.LanguageModel;
import ua.com.dentalclinic.vo.base.TreatmentsTranslationsVO;
import ua.com.dentalclinic.vo.base.TreatmentsVO;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: roman_b
 * Date: 10/29/13
 * Time: 5:44 PM
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
public class TreatmentsModel {

    public static final int ALL_CATEGORY_ID = 0;

    @Inject
    private TreatmentsService service;

    public TreatmentsModel() {

    }

    public List<TreatmentsVO> getAllTreatments() {
        return service.getAllTreatments(LanguageModel.CURRENT_LANGUAGE.getId());
    }

    public List<TreatmentsVO> getTreatmentsByCategories(String[] categoryIds) {
        return (categoryIds != null && categoryIds.length > 0) ?
                service.getTreatmentsByCategoryAndLang(categoryIds, LanguageModel.CURRENT_LANGUAGE.getId()) :
                null;
    }

    public List<TreatmentsVO> getAllCategories()
    {
        return service.getCategoryTreatments(LanguageModel.CURRENT_LANGUAGE.getId());
    }

   /* public int insertCategory(String name) {
        TreatmentCategoryVO item = new TreatmentCategoryVO();
        TreatmentCategoryTranslationsVO translation = new TreatmentCategoryTranslationsVO();
        translation.setTreatmentCategoryByCategoryId(item);
        translation.setName(name);
        translation.setLangId(LanguageModel.CURRENT_LANGUAGE.getId());
        item.getTreatmentCategoryTranslationsesById().add(translation);
        return service.insertCategory(item);
    }*/

    public int insertTreatment(int catId, String name, int lowPrice, int topPrice, String description, ArrayList<String> imagesURL) {
        TreatmentsVO treatment = new TreatmentsVO();
        TreatmentsTranslationsVO translation = new TreatmentsTranslationsVO();
        translation.setLangId(LanguageModel.CURRENT_LANGUAGE.getId());
        translation.setName(name);
        translation.setDescription(description);
        translation.setTreatmentsByTreatmentId(treatment);
        treatment.getTreatmentsTranslationsesById().add(translation);
        //treatment.setLowPrice(lowPrice);
        //treatment.setTopPrice(topPrice);
       // treatment.setTreatmentCategoryByCategoryId(getCategoryById(catId));
        //treatment.setCategoryId(catId);

        return service.insertTreatment(treatment);
    }
}
