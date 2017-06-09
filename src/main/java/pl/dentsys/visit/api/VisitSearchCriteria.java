package pl.dentsys.visit.api;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class VisitSearchCriteria {
	
	@JsonFormat(pattern = "dd/mm/yyyy HH:mm")
	private LocalDateTime dateFrom;
	@JsonFormat(pattern = "dd/mm/yyyy HH:mm")
	private LocalDateTime dateTo;
	private Long doctorId;
	private Long patientId;

}
