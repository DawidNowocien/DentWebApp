package pl.dentsys.patient.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dentsys.patient.api.PatientDto;
import pl.dentsys.patient.api.PatientSearchCriteria;
import pl.dentsys.patient.api.PatientSimpleDto;
import pl.dentsys.patient.domain.PatientEntity;
import pl.dentsys.patient.domain.PatientRepository;
import pl.dentsys.patient.domain.PatientSpecification;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepo;
	
	@Autowired
	private PatientDtoAssembler patientAssembler;
	
	public void addPatient(PatientSimpleDto patient){
		
		PatientEntity patientEntity=new PatientEntity();
		patientEntity.setName(patient.getName());
		patientEntity.setSurname(patient.getSurname());
		patientEntity.setBirthDate(patient.getBirthDate());
		patientEntity.setCity(patient.getCity());
		patientEntity.setCountry(patient.getCountry());
		patientEntity.setPesel(patient.getPesel());
		patientEntity.setProvince(patient.getProvince());
		patientEntity.setPhoneNumber1(patient.getPhoneNumber1());
		patientEntity.setPhoneNumber2(patient.getPhoneNumber2());
		patientEntity.setPostalCode(patient.getPostCode());
		patientEntity.setEmail(patient.getMail());
		patientEntity.setStreetAddress(patient.getAddress());
		patientRepo.save(patientEntity);
	}
	
	public PatientDto getPatient(long id){
		
		PatientEntity entity=patientRepo.findOne(id);
		
		return patientAssembler.patientToDto(entity);
		
	}
	
	public List<PatientDto> searchPatient(PatientSearchCriteria searchCriteria){
		
		PatientSpecification spec=new PatientSpecification(searchCriteria);
		
		List<PatientEntity> patientEntityList=patientRepo.findAll(spec);
		
		return patientAssembler.patientToDtoList(patientEntityList);
		
	}
	
	public void updatePatient(PatientSimpleDto patient,Long patientId){
		
		PatientEntity patientEntity=patientRepo.findOne(patientId);
		patientEntity.setName(patient.getName());
		patientEntity.setSurname(patient.getSurname());
		patientEntity.setBirthDate(patient.getBirthDate());
		patientEntity.setCity(patient.getCity());
		patientEntity.setCountry(patient.getCountry());
		patientEntity.setPesel(patient.getPesel());
		patientEntity.setProvince(patient.getProvince());
		patientEntity.setPhoneNumber1(patient.getPhoneNumber1());
		patientEntity.setPhoneNumber2(patient.getPhoneNumber2());
		patientEntity.setPostalCode(patient.getPostCode());
		patientEntity.setEmail(patient.getMail());
		patientEntity.setStreetAddress(patient.getAddress());
		patientRepo.saveAndFlush(patientEntity);
	}
	
	public void deletePatient(Long patientId){
		patientRepo.delete(patientId);
	}

}
