package pl.dentsys.doctor.api;

import lombok.Data;
import pl.dentsys.common.Dict;

@Data
public class DoctorDto extends DoctorBasic{
	
	private Long id;
	private Dict specialization;

}
