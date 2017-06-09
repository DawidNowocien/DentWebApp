package pl.dentsys.patient.api;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientSimpleDto {
	
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
