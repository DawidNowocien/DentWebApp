package pl.dentsys.doctor.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorSimpleDto extends DoctorBasic{
	
	private Long specializationId;

}
