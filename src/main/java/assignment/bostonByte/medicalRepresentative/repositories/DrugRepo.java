package assignment.bostonByte.medicalRepresentative.repositories;

import assignment.bostonByte.medicalRepresentative.entity.DrugList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface DrugRepo extends JpaRepository<DrugList, String> {
    @Query("select count(*) > 0 from DrugList where name = ?1")
    boolean findByName(String name);

    @Transactional
    DrugList findByProductCode(String productCode);

}
