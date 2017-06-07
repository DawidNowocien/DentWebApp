package pl.dentsys.visit.api;

import java.util.List;

import lombok.Data;

@Data
public class VisitSimpleDto {
	
	private Long doctorId;
	private Long patientId;
	private String visitDate;
	private List<TreatmentDict> treatmentList;
	

}
