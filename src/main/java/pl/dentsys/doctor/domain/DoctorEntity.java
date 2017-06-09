package pl.dentsys.doctor.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="DOCTOR")
@Data
public class DoctorEntity {
	
	@Column(name="BIRTH_DATE")
	private LocalDate birthDate;

	private String city;

	private String country;

	private String email;

	@Id
	@SequenceGenerator(name="Doctor_Gen", sequenceName="DOCTOR_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="Doctor_Gen")
	@Column(name="ID")
	private Long id;

	private String name;

	private Long pesel;

	@Column(name="PHONE_NUMBER1")
	private String phoneNumber1;

	@Column(name="PHONE_NUMBER2")
	private String phoneNumber2;

	@Column(name="POSTAL_CODE")
	private String postalCode;

	private String province;

	@Column(name="SPECIALIZATION_ID")
	private Long specializationId;

	@Column(name="STREET_ADDRESS")
	private String streetAddress;

	private String surname;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SPECIALIZATION_ID",insertable=false, updatable=false)
	public SpecializationDictEntity specializationDict;

}
