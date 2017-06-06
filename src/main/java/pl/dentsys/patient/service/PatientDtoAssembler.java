package pl.dentsys.patient.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.dentsys.patient.api.PatientDto;
import pl.dentsys.patient.domain.PatientEntity;

@Component
public class PatientDtoAssembler {
	
	public PatientDto patientToDto(PatientEntity entity){
		PatientDto dto=new PatientDto();
		dto.setId(entity.getId().longValue());
		dto.setName(entity.getName());
		dto.setSurname(entity.getSurname());
		dto.setBirthDate(entity.getBirthDate().toString());
		dto.setAddress(entity.getStreetAddress());
		dto.setCountry(entity.getCountry());
		dto.setCity(entity.getCity());
		dto.setMail(entity.getEmail());
		dto.setPesel(entity.getPesel());
		dto.setPhoneNumber1(entity.getPhoneNumber1());
		dto.setPhoneNumber2(entity.getPhoneNumber2());
		dto.setPostCode(entity.getPostalCode());
		dto.setProvince(entity.getProvince());
	
		return dto;
	}
	
	public List<PatientDto> patientToDtoList(List<PatientEntity> entityList){
		
		List<PatientDto> patientList=new ArrayList<>();
		
		for(PatientEntity entity:entityList){
			patientList.add(patientToDto(entity));
		}
				
		return patientList;		
	}

}
