package assignment.bostonByte.medicalRepresentative.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class DrugList {
    @NotNull
    String name; //dfgdgf
    @Lob
    String description; //"dsfgdfg",
    @Lob
    String about; //"adfg",
    @Lob
    String symptoms; //"sdfgsdfg",
    String moleculeName; //"sdfhsg",
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    String productCode; //"sdadfs"
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "representative_id")
    Representative representative;

    public DrugList(@NotNull String name, String description, String about, String symptoms, String moleculeName) {
        this.name = name;
        this.description = description;
        this.about = about;
        this.symptoms = symptoms;
        this.moleculeName = moleculeName;
    }

    @Override
    public String toString() {
        return "DrugList{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", about='" + about + '\'' +
                ", symptoms='" + symptoms + '\'' +
                ", moleculeName='" + moleculeName + '\'' +
                ", productCode='" + productCode + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getMoleculeName() {
        return moleculeName;
    }

    public void setMoleculeName(String moleculeName) {
        this.moleculeName = moleculeName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Representative getRepresentative() {
        return representative;
    }

    public void setRepresentative(Representative representative) {
        this.representative = representative;
    }

    public DrugList() {
    }

}
