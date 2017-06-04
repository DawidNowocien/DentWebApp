package pl.dentsys.patient.api;

import lombok.Data;

@Data
public class PatientSearchCriteria {
	
	private String name;
	private String surename;
	private Long pesel;
	

}
