package assignment.bostonByte.medicalRepresentative.controller;

import assignment.bostonByte.medicalRepresentative.entity.DrugList;
import assignment.bostonByte.medicalRepresentative.entity.Representative;
import assignment.bostonByte.medicalRepresentative.repositories.DrugRepo;
import assignment.bostonByte.medicalRepresentative.repositories.RepresentativeRepo;
import assignment.bostonByte.medicalRepresentative.util.UtilityFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/representative")
public class MedicalController {
    @Autowired
    RepresentativeRepo representativeRepo;
    @Autowired
    DrugRepo drugRepo;
    @Autowired
    UtilityFunctions utilityFunctions;

    @PostMapping("/create")
    public ResponseEntity<Representative> createRepresentative(@RequestBody Representative representative) {
        Representative representative1 = representativeRepo.save(representative);
        List<DrugList> drugListSet = new ArrayList<>();
        System.out.println(representative1.getRepresentativeEmployeeId() + "IS Emp id" + representative1.toString());
        for (DrugList drugList : representative.getDrugList()) {
            DrugList drugList1 = new DrugList(drugList.getName(), drugList.getDescription(), drugList.getAbout(), drugList.getSymptoms(), drugList.getMoleculeName());
            drugList1.setRepresentative(representative1);
            System.out.println("SAVING DRUGLIST");
        }
        return new ResponseEntity<>(representative1, HttpStatus.CREATED);
    }

    @PostMapping("/edit")
    public String Edit(@RequestBody Representative representative) {

        Representative representative_exist = representativeRepo.findByRepresentativeEmployeeId(representative.getRepresentativeEmployeeId());
        if (representative_exist != null) {
            representative_exist = utilityFunctions.updateRepresentative(representative_exist, representative);
            representativeRepo.save(representative_exist);
            for (DrugList drugList : representative.getDrugList()) {
                DrugList drugList_exist = drugRepo.findByProductCode(drugList.getProductCode());
                System.out.println(drugList_exist == null);
                if (drugList_exist != null) {
                    drugList_exist = utilityFunctions.updateDrugList(drugList_exist, drugList, representative);
                    drugRepo.save(drugList_exist);
                } else {
                    saveDrugList(drugList, representative_exist);
                }
            }
            return "representative successfuly updated";
        } else
            return "representative does not exits";
    }

    @PostMapping("/delete")
    public String removeRepresentative(@RequestParam Long empId) {
        representativeRepo.deleteByRepresentativeEmployeeId(empId);
        return "Transaction successful";
    }

    @GetMapping("/getRepresentatives")
    public ResponseEntity<List<Representative>> getRepresentatives() {
        List<Representative> representatives = (List<Representative>) representativeRepo.findAllRepresentative();
        return new ResponseEntity<>(representatives, HttpStatus.OK);
    }

    public void saveDrugList(DrugList drugList, Representative representative_exist) {
        DrugList newDrugList = new DrugList(drugList.getName(), drugList.getDescription(), drugList.getAbout(), drugList.getSymptoms(), drugList.getMoleculeName());
        newDrugList.setRepresentative(representative_exist);
        drugRepo.save(newDrugList);
        System.out.println("SAVING DRUGLIST");
    }

    @PostMapping("/getRepresentativeById")
    public ResponseEntity<Representative> getRepresentativeById(@RequestParam Long id) {
        Representative representative = representativeRepo.findByRepresentativeEmployeeId(id);
        return new ResponseEntity<Representative>(representative, HttpStatus.OK);
    }

    private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "representativeEmployeeId");

    }
}
