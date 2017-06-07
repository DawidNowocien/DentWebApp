package pl.dentsys.visit.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the VISIT_TREATMENT database table.
 * 
 */
@Entity
@Table(name="VISIT_TREATMENT")
@Data
@IdClass(VisitTreatmentId.class)
public class VisitTreatmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TREATMENT_ID")
	private Long treatmentId;
	
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "VISIT_ID", nullable = false)
	public VisitEntity visit;

}