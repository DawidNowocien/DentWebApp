package pl.dentsys.patient.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name="PATIENT")
@Data
public class PatientEntity implements Serializable{
	
	@Id
	@SequenceGenerator(name="Patient_Gen", sequenceName="PATIENT_SEQ")
	@GeneratedValue(generator="Patient_Gen")
	@Column(name="ID")
	private BigDecimal id;
	
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="BIRTH_DATE")
	private Date birthDate;

	private String city;

	private String country;

	private String email;

	private String name;

	private BigDecimal pesel;

	@Column(name="PHONE_NUMBER1")
	private BigDecimal phoneNumber1;

	@Column(name="PHONE_NUMBER2")
	private BigDecimal phoneNumber2;

	@Column(name="POSTAL_CODE")
	private String postalCode;

	private String province;

	@Column(name="STREET_ADDRESS")
	private String streetAddress;

	private String surname;

}
