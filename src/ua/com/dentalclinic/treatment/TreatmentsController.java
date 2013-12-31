package ua.com.dentalclinic.treatment;

import ua.com.dentalclinic.vo.base.TreatmentCategoryVO;
import ua.com.dentalclinic.vo.base.TreatmentsVO;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: roman_b
 * Date: 10/4/13
 * Time: 4:59 PM
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@RequestScoped
public class TreatmentsController {

    @Inject
    private TreatmentsModel model;

    public TreatmentsController()
    {

    }

    public List<TreatmentsVO> getAllTreatments()
    {
        return model.getAllTreatments();
    }

    public List<TreatmentCategoryVO> getAllCategories()
    {
        return model.getAllCategories();
    }

    public int insertCategory(String name)
    {
        return model.insertCategory(name);
    }

    public int insertTreatment(int catId, String name, int lowPrice, int topPrice, String description, ArrayList<String> imagesURL)
    {
        return model.insertTreatment(catId, name, lowPrice, topPrice,  description, imagesURL);
    }

    public List<TreatmentsVO> getTreatmentsByCategories(String[] categoryIds)
    {
        return model.getTreatmentsByCategories(categoryIds);
    }
}
