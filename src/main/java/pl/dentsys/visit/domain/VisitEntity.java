package pl.dentsys.visit.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
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

import lombok.Data;
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

	@Column(name="VISIT_DATE")
	private LocalDateTime visitDate;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "visit",cascade = CascadeType.ALL)
	public List<VisitTreatmentEntity> treatmentList;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PATIENT_ID",insertable=false, updatable=false)
	public PatientEntity patient;

}
