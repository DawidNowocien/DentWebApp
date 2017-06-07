package pl.dentsys.visit.api;

import lombok.Data;

@Data
public class VisitSearchCriteria {
	
	private String dateFrom;
	private String dateTo;
	private Long doctorId;
	private Long patientId;

}
