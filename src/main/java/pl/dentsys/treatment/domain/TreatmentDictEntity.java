package pl.dentsys.treatment.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


/**
 * The persistent class for the TREATMENT_DICT database table.
 * 
 */
@Entity
@Table(name="TREATMENT_DICT")
@Data
public class TreatmentDictEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name="LABEL")
	private String label;

}