package assignment.bostonByte.medicalRepresentative.repositories;

import assignment.bostonByte.medicalRepresentative.entity.Representative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface RepresentativeRepo extends JpaRepository<Representative, Long> {
    @Transactional
    Representative findByRepresentativeEmployeeId(Long representativeEmployeeId);

    @Transactional
    void deleteByRepresentativeEmployeeId(Long representativeEmployeeId);

    @Query("select r.representativeEmployeeId,  r.representativeFirstName as representativeFirstName, r.representativeLastName, r.companyId, r.representativeAddress, r.representativeCountry, r.representativeState, r.representativeCity, r.representativePinCode from Representative r")
    List<Representative> findAllRepresentative();
}
