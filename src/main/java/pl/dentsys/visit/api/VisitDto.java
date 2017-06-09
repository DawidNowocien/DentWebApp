package pl.dentsys.visit.api;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import pl.dentsys.treatment.api.TreatmentDict;

@Data
public class VisitDto{
	
	private Long visitId;
	private PersonShort doctor;
	private PersonShort patient;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime visitDate;
	private List<TreatmentDict> treatmentList;

}
