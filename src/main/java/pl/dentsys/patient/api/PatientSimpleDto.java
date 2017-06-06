package pl.dentsys.patient.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientSimpleDto {
	
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
