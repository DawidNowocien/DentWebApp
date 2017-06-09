package pl.dentsys.visit.api;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class VisitSearchCriteria {
	
	@JsonFormat(pattern = "dd/MM/YYYY HH:mm")
	private String dateFrom;
	@JsonFormat(pattern = "dd/MM/YYYY HH:mm")
	private String dateTo;
	private Long doctorId;
	private Long patientId;

}
