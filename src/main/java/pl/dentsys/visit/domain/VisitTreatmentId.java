package pl.dentsys.visit.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class VisitTreatmentId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4825769479309089569L;
	
	private Long visit;
	private Long treatmentId;

}
