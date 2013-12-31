package ua.com.dentalclinic.dto.builder;

import ua.com.dentalclinic.dto.TreatmentDTO;
import ua.com.dentalclinic.vo.base.TreatmentsVO;

/**
 * Created with IntelliJ IDEA.
 * User: roman_b
 * Date: 11/22/13
 * Time: 1:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class TreatmentsDTOBuilder {

    public TreatmentDTO buildTreatmentDTO(TreatmentsVO treatment)
    {
        TreatmentDTO result = new TreatmentDTO();
        result.setId(treatment.getId());
        return null;
    }
}
