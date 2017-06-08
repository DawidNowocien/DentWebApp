package pl.dentsys.treatment.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentRepository extends JpaRepository<TreatmentDictEntity, Long> {

}
