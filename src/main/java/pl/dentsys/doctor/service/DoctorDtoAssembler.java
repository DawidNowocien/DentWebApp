package pl.dentsys.doctor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.dentsys.common.Dict;
import pl.dentsys.doctor.api.DoctorDto;
import pl.dentsys.doctor.domain.DoctorEntity;
import pl.dentsys.doctor.domain.SpecializationDictEntity;

@Component
public class DoctorDtoAssembler {
	
	public DoctorDto doctorToDto(DoctorEntity entity){
		DoctorDto dto=new DoctorDto();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setSurname(entity.getSurname());
		dto.setBirthDate(entity.getBirthDate());
		dto.setAddress(entity.getStreetAddress());
		dto.setCountry(entity.getCountry());
		dto.setCity(entity.getCity());
		dto.setMail(entity.getEmail());
		dto.setPesel(entity.getPesel());
		dto.setPhoneNumber1(entity.getPhoneNumber1());
		dto.setPhoneNumber2(entity.getPhoneNumber2());
		dto.setPostCode(entity.getPostalCode());
		dto.setProvince(entity.getProvince());
		Dict specializationDict=new Dict(entity.getSpecializationDict().getId(),entity.getSpecializationDict().getLabel());
		dto.setSpecialization(specializationDict);
	
		return dto;
	}
	
	public List<DoctorDto> doctorToDtoList(List<DoctorEntity> entityList){
		
		List<DoctorDto> doctorList=new ArrayList<>();
		
		for(DoctorEntity entity:entityList){
			doctorList.add(doctorToDto(entity));
		}
				
		return doctorList;		
	}
	
	public Dict specializationToDto(SpecializationDictEntity entity){
		return new Dict(entity.getId(),entity.getLabel());
	}
	
	public List<Dict> specializationToDtoList(List<SpecializationDictEntity> entityList){
		List<Dict> dtoList=new ArrayList<>();
		for(SpecializationDictEntity entity:entityList){
			dtoList.add(specializationToDto(entity));
		}
		return dtoList;
	}

}
