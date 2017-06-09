package pl.dentsys.doctor.api;

import lombok.Data;

@Data
public class DoctorBasic {

	private String name;
	private String surname;
	private String birthDate;
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
