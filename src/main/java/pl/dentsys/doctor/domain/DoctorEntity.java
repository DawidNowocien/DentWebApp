package pl.dentsys.doctor.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name="DOCTOR")
@Data
public class DoctorEntity {
	
	@Temporal(TemporalType.DATE)
	@Column(name="BIRTH_DATE")
	private Date birthDate;

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
	private BigDecimal phoneNumber1;

	@Column(name="PHONE_NUMBER2")
	private BigDecimal phoneNumber2;

	@Column(name="POSTAL_CODE")
	private String postalCode;

	private String province;

	@Column(name="SPECIALIZATION_ID")
	private BigDecimal specializationId;

	@Column(name="STREET_ADDRESS")
	private String streetAddress;

	private String surname;

}
