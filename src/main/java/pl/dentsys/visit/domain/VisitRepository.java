package pl.dentsys.visit.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.dentsys.visit.api.VisitSearchCriteria;

@Repository
public interface VisitRepository extends JpaRepository<VisitEntity,Long>{
	
	@Query("select v from VisitEntity v where v.doctorId = :#{#sc.doctorId} and v.visitDate <= :#{#sc.dateTo} and v.visitDate >= :#{#sc.dateFrom}")
	List<VisitEntity> findVisitsByDoctorAndDates(@Param("sc") VisitSearchCriteria searchCriteria);
	
	@Query("select v from VisitEntity v where v.doctorId = :#{#sc.doctorId} and v.visitDate <= :#{#sc.dateTo} and v.visitDate >= :#{#sc.dateFrom} and v.patientId=:#{#sc.patientId}")
	List<VisitEntity> findVisitsByDoctorAndPatientidAndDates(@Param("sc") VisitSearchCriteria searchCriteria);

}
