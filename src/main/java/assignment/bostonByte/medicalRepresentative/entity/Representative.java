package assignment.bostonByte.medicalRepresentative.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Representative {
    @NotNull
    String representativeFirstName;
    @NotNull
    String representativeLastName;
    @NotNull
    Integer companyId; //123
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long representativeEmployeeId; //"10012155",
    @Lob
    String representativeAddress;//"PLOT NO 38 GALI NO 4 LALITAMBA 110081",
    @NotNull
    @Size(max = 3)
    String representativeCountry; //IN
    @NotNull
    @Size(max = 2)
    String representativeState; //MH,
    @NotNull
    String representativeCity; //Pune,
    @Size(max = 8)
    String representativePinCode; //"110081",
    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true,
            cascade = {
                    CascadeType.ALL
            },
            mappedBy = "representative")
    List<DrugList> drugList;

    public String getRepresentativeFirstName() {
        return representativeFirstName;
    }

    public void setRepresentativeFirstName(String representativeFirstName) {
        this.representativeFirstName = representativeFirstName;
    }

    public String getRepresentativeLastName() {
        return representativeLastName;
    }

    public void setRepresentativeLastName(String representativeLastName) {
        this.representativeLastName = representativeLastName;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Long getRepresentativeEmployeeId() {
        return representativeEmployeeId;
    }

    public void setRepresentativeEmployeeId(Long representativeEmployeeId) {
        this.representativeEmployeeId = representativeEmployeeId;
    }

    public String getRepresentativeAddress() {
        return representativeAddress;
    }

    public void setRepresentativeAddress(String representativeAddress) {
        this.representativeAddress = representativeAddress;
    }

    public String getRepresentativeCountry() {
        return representativeCountry;
    }

    public void setRepresentativeCountry(String representativeCountry) {
        this.representativeCountry = representativeCountry;
    }

    public String getRepresentativeState() {
        return representativeState;
    }

    public Representative(@NotNull String representativeFirstName, @NotNull String representativeLastName, @NotNull @Size(max = 3) Integer companyId, String representativeAddress, @NotNull @Size(max = 3) String representativeCountry, @NotNull @Size(max = 2) String representativeState, @NotNull String representativeCity, @Size(max = 5) String representativePinCode) {
        this.representativeFirstName = representativeFirstName;
        this.representativeLastName = representativeLastName;
        this.companyId = companyId;
        this.representativeAddress = representativeAddress;
        this.representativeCountry = representativeCountry;
        this.representativeState = representativeState;
        this.representativeCity = representativeCity;
        this.representativePinCode = representativePinCode;
        this.drugList = drugList;
    }

    public void setRepresentativeState(String representativeState) {
        this.representativeState = representativeState;
    }

    public String getRepresentativeCity() {
        return representativeCity;
    }

    public void setRepresentativeCity(String representativeCity) {
        this.representativeCity = representativeCity;
    }

    public String getRepresentativePinCode() {
        return representativePinCode;
    }

    public void setRepresentativePinCode(String representativePinCode) {
        this.representativePinCode = representativePinCode;
    }

    public List<DrugList> getDrugList() {
        return drugList;
    }

    public void setDrugList(List<DrugList> drugList) {
        this.drugList = drugList;
    }

    public Representative(Representative representative) {
        this.representativeFirstName = representative.representativeFirstName;
        this.representativeLastName = representative.representativeLastName;
        this.companyId = representative.companyId;
        this.representativeAddress = representative.representativeAddress;
        this.representativeCountry = representative.representativeCountry;
        this.representativeState = representative.representativeState;
        this.representativeCity = representative.representativeCity;
        this.representativePinCode = representative.representativePinCode;
    }

    public Representative() {

    }

    @Override
    public String toString() {
        return "Representative{" +
                "representativeFirstName='" + representativeFirstName + '\'' +
                ", representativeLastName='" + representativeLastName + '\'' +
                ", companyId=" + companyId +
                ", representativeEmployeeId=" + representativeEmployeeId +
                ", representativeAddress='" + representativeAddress + '\'' +
                ", representativeCountry='" + representativeCountry + '\'' +
                ", representativeState='" + representativeState + '\'' +
                ", representativeCity='" + representativeCity + '\'' +
                ", representativePinCode='" + representativePinCode + '\'' +
                ", drugList=" + drugList +
                '}';
    }
    //"drugList" : []
}
