package pl.dentsys.visit.api;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class VisitSimpleDto {
	
	private Long doctorId;
	private Long patientId;
	private Date visitDate;
	private List<TreatmentDict> treatmentList;
	

}
