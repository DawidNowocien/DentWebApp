package pl.dentsys.patient.api;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PatientDto {
	
	private String name;
	private String surename;
	private LocalDate localDate;
	private String address;
	private String postCode;
	private String region;
	private String country;
	private String phone;
	private String mail;

}
