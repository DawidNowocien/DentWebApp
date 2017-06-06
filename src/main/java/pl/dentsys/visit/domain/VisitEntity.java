package pl.dentsys.visit.domain;

import java.io.Serializable;
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
@Table(name="VISIT")
@Data
public class VisitEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name="DOCTOR_ID")
	private Long doctorId;

	@Id
	@SequenceGenerator(name="Visit_Gen", sequenceName="VISIT_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="Visit_Gen")
	@Column(name="ID")
	private Long id;

	@Column(name="PATIENT_ID")
	private Long patientId;

	@Temporal(TemporalType.DATE)
	@Column(name="VISIT_DATE")
	private Date visitDate;

}
