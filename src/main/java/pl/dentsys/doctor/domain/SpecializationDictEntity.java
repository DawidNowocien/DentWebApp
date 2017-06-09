package pl.dentsys.doctor.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="SPECIALIZATION_DICT")
@Data
public class SpecializationDictEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name="LABEL")
	private String label;

}
