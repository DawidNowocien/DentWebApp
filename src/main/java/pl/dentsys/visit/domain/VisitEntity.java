package pl.dentsys.visit.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import pl.dentsys.doctor.domain.DoctorEntity;
import pl.dentsys.patient.domain.PatientEntity;

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
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "visit",cascade = CascadeType.ALL)
	public List<VisitTreatmentEntity> treatmentList;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	@JoinColumn(name = "PATIENT_ID",insertable=false, updatable=false)
	public PatientEntity patient;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
	@JoinColumn(name = "DOCTOR_ID",insertable=false, updatable=false)
	public DoctorEntity doctor;

}
