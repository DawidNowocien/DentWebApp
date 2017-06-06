package pl.dentsys.visit.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the VISIT_TREATMENT database table.
 * 
 */
@Entity
@Table(name="VISIT_TREATMENT")
@Data
public class VisitTreatmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="TREATMENT_ID")
	private Long treatmentId;

	@Id
	@Column(name="VISIT_ID")
	private Long visitId;

}