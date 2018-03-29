package assignment.bostonByte.medicalRepresentative.util;

import assignment.bostonByte.medicalRepresentative.entity.DrugList;
import assignment.bostonByte.medicalRepresentative.entity.Representative;
import org.springframework.stereotype.Component;

@Component
public class UtilityFunctions {

    public Representative updateRepresentative(Representative representative_exist, Representative representative) {
        representative_exist.setRepresentativeFirstName(representative.getRepresentativeFirstName());
        representative_exist.setRepresentativeLastName(representative.getRepresentativeLastName());
        representative_exist.setRepresentativeAddress(representative.getRepresentativeAddress());
        representative_exist.setRepresentativeCity(representative.getRepresentativeCity());
        representative_exist.setRepresentativeCountry(representative.getRepresentativeCountry());
        representative_exist.setRepresentativePinCode(representative.getRepresentativePinCode());
        representative_exist.setRepresentativeState(representative.getRepresentativeState());
        return representative_exist;
    }

    public DrugList updateDrugList(DrugList drugList_exist, DrugList drugList, Representative representative) {
        drugList_exist.setAbout(drugList.getAbout());
        drugList_exist.setName(drugList.getName());
        drugList_exist.setDescription(drugList.getDescription());
        drugList_exist.setMoleculeName(drugList_exist.getMoleculeName());
        drugList_exist.setSymptoms(drugList_exist.getSymptoms());
        return drugList_exist;
    }
}
