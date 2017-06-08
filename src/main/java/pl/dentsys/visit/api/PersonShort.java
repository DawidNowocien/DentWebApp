package pl.dentsys.visit.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonShort {

	private Long id;
	private String name;
	private String surname;
	private Long pesel;
	
}
