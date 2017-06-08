package pl.dentsys.visit.api;

import java.util.List;

import lombok.Data;
import pl.dentsys.treatment.api.TreatmentDict;

@Data
public class VisitDto{
	
	private Long visitId;
	private PersonShort doctor;
	private PersonShort patient;
	private String visitDate;
	private List<TreatmentDict> treatmentList;

}
