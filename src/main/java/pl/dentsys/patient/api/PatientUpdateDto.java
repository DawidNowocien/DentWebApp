package pl.dentsys.patient.api;

import lombok.Data;

@Data
public class PatientUpdateDto extends PatientDto{
	
	private Long patientId;

}
