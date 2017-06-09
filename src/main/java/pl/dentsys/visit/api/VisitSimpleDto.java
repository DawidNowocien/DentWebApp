package pl.dentsys.visit.api;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class VisitSimpleDto {
	
	private Long doctorId;
	private Long patientId;
	@JsonFormat(pattern = "dd/mm/yyyy HH:mm")
	private LocalDateTime visitDate;
	private List<Long> treatmentList;
	

}
