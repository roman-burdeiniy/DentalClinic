package ua.com.dentalclinic.treatment;


import ua.com.dentalclinic.language.LanguageModel;
import ua.com.dentalclinic.vo.base.TreatmentCategoryTranslationsVO;
import ua.com.dentalclinic.vo.base.TreatmentCategoryVO;
import ua.com.dentalclinic.vo.base.TreatmentsTranslationsVO;
import ua.com.dentalclinic.vo.base.TreatmentsVO;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
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

    public List<TreatmentCategoryVO> categories;
    public List<TreatmentsVO> allTreatments;
    public List<TreatmentsVO> nonCategorizedTreatments;

    @Inject
    private TreatmentsService service;

    public TreatmentsModel() {

    }

    public List<TreatmentsVO> getAllTreatments() {
        allTreatments = service.getAllTreatments(LanguageModel.CURRENT_LANGUAGE.getId());
        return allTreatments;
    }

    public List<TreatmentCategoryVO> getAllCategories() {
        categories = service.getAllCategoriesByLang(LanguageModel.CURRENT_LANGUAGE.getId());
        return categories;
    }

    public List<TreatmentsVO> getTreatmentsByCategories(String[] categoryIds) {
        List<TreatmentsVO> result = service.getTreatmentsByCategoryAndLang(categoryIds, LanguageModel.CURRENT_LANGUAGE.getId());
        if (categoryIds != null) {
            for (String id : categoryIds) {
                try {
                    getCategoryById(Integer.getInteger(id)).setTreatmentsesById(result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } else {
            nonCategorizedTreatments = result;
        }
        return result;
    }

    public int insertCategory(String name) {
        TreatmentCategoryVO item = new TreatmentCategoryVO();
        TreatmentCategoryTranslationsVO translation = new TreatmentCategoryTranslationsVO();
        translation.setTreatmentCategoryByCategoryId(item);
        translation.setName(name);
        translation.setLangId(LanguageModel.CURRENT_LANGUAGE.getId());
        item.getTreatmentCategoryTranslationsesById().add(translation);
        return service.insertCategory(item);
    }

    public int insertTreatment(int catId, String name, int lowPrice, int topPrice, String description, ArrayList<String> imagesURL) {
        TreatmentCategoryVO categoryToAdd = getCategoryById(catId);
        TreatmentsVO treatment = new TreatmentsVO();
        TreatmentsTranslationsVO translation = new TreatmentsTranslationsVO();
        translation.setLangId(LanguageModel.CURRENT_LANGUAGE.getId());
        translation.setName(name);
        translation.setDescription(description);
        translation.setTreatmentsByTreatmentId(treatment);
        treatment.getTreatmentsTranslationsesById().add(translation);
        treatment.setLowPrice(lowPrice);
        treatment.setTopPrice(topPrice);
        treatment.setTreatmentCategoryByCategoryId(getCategoryById(catId));

        return service.insertTreatment(treatment);
    }

    public TreatmentCategoryVO getCategoryById(int catId) {
        if (categories == null)
            return null;
        for (TreatmentCategoryVO category : categories) {
            if (category.getId() == catId) {
                return category;
            }
        }
        return null;
    }
}
