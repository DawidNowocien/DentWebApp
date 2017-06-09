package pl.dentsys.doctor.api;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class DoctorBasic {

	private String name;
	private String surname;
	@JsonFormat(pattern = "dd/mm/rrrr")
	private LocalDate birthDate;
	private String city;
	private Long pesel;
	private String address;
	private String postCode;
	private String province;
	private String country;
	private String phoneNumber1;
	private String phoneNumber2;
	private String mail;
	
}
