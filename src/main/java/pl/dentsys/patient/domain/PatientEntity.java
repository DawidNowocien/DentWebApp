package pl.dentsys.patient.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="PATIENT")
@Data
public class PatientEntity implements Serializable{
	
	@Id
	@SequenceGenerator(name="Patient_Gen", sequenceName="PATIENT_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="Patient_Gen")
	@Column(name="ID")
	private Long id;
	
	private static final long serialVersionUID = 1L;

	@Column(name="BIRTH_DATE")
	private LocalDate birthDate;

	private String city;

	private String country;

	private String email;

	private String name;

	private Long pesel;

	@Column(name="PHONE_NUMBER1")
	private String phoneNumber1;

	@Column(name="PHONE_NUMBER2")
	private String phoneNumber2;

	@Column(name="POSTAL_CODE")
	private String postalCode;

	private String province;

	@Column(name="STREET_ADDRESS")
	private String streetAddress;

	private String surname;

}
