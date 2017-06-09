package pl.dentsys.visit.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryParameters {
	
	private LocalDateTime dateFrom;
	private LocalDateTime dateTo;
	private Long doctorId;
	private Long patientId;

}
