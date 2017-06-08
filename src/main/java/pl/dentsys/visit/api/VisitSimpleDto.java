package pl.dentsys.visit.api;

import java.util.List;

import lombok.Data;
import pl.dentsys.treatment.api.TreatmentDict;

@Data
public class VisitSimpleDto {
	
	private Long doctorId;
	private Long patientId;
	private String visitDate;
	private List<TreatmentDict> treatmentList;
	

}
