package pl.dentsys.doctor.api;

import lombok.Data;

@Data
public class DoctorSearchCriteria {
	
	private String name;
	private String surname;
	private Long pesel;
	private Long specializationId;
	

}
