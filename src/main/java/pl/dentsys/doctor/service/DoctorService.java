package pl.dentsys.doctor.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dentsys.doctor.api.DoctorDto;
import pl.dentsys.doctor.api.DoctorSearchCriteria;
import pl.dentsys.doctor.api.DoctorSimpleDto;
import pl.dentsys.doctor.domain.DoctorEntity;
import pl.dentsys.doctor.domain.DoctorRepository;
import pl.dentsys.doctor.domain.DoctorSpecification;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepo;
	
	@Autowired
	private DoctorDtoAssembler doctorAssembler;
	
	public void addDoctor(DoctorSimpleDto doctor){
		
		DoctorEntity doctorEntity=new DoctorEntity();
		doctorEntity.setName(doctor.getName());
		doctorEntity.setSurname(doctor.getSurname());
		doctorEntity.setBirthDate(new Date());
		doctorEntity.setCity(doctor.getCity());
		doctorEntity.setCountry(doctor.getCountry());
		doctorEntity.setPesel(doctor.getPesel());
		doctorEntity.setProvince(doctor.getProvince());
		doctorEntity.setPhoneNumber1(doctor.getPhoneNumber1());
		doctorEntity.setPhoneNumber2(doctor.getPhoneNumber2());
		doctorEntity.setPostalCode(doctor.getPostCode());
		doctorEntity.setEmail(doctor.getMail());
		doctorEntity.setStreetAddress(doctor.getAddress());
		doctorEntity.setSpecializationId(doctor.getSpecializationId());
		doctorRepo.save(doctorEntity);
	}
	
	public DoctorDto getDoctor(Long id){
		
		DoctorEntity entity=doctorRepo.findOne(id);
		
		return doctorAssembler.doctorToDto(entity);
		
	}
	
	public List<DoctorDto> searchDoctor(DoctorSearchCriteria searchCriteria){
		
		DoctorSpecification spec=new DoctorSpecification(searchCriteria);
		
		List<DoctorEntity> doctorEntityList=doctorRepo.findAll(spec);
		
		return doctorAssembler.doctorToDtoList(doctorEntityList);
		
	}
	
	public void updateDoctor(DoctorSimpleDto doctor,Long doctorId){
		
		DoctorEntity doctorEntity=doctorRepo.findOne(doctorId);
		doctorEntity.setName(doctor.getName());
		doctorEntity.setSurname(doctor.getSurname());
		doctorEntity.setBirthDate(new Date());
		doctorEntity.setCity(doctor.getCity());
		doctorEntity.setCountry(doctor.getCountry());
		doctorEntity.setPesel(doctor.getPesel());
		doctorEntity.setProvince(doctor.getProvince());
		doctorEntity.setPhoneNumber1(doctor.getPhoneNumber1());
		doctorEntity.setPhoneNumber2(doctor.getPhoneNumber2());
		doctorEntity.setPostalCode(doctor.getPostCode());
		doctorEntity.setEmail(doctor.getMail());
		doctorEntity.setStreetAddress(doctor.getAddress());
		doctorEntity.setSpecializationId(doctor.getSpecializationId());
		doctorRepo.saveAndFlush(doctorEntity);
	}
	
	public void deleteDoctor(Long doctorId){
		doctorRepo.delete(doctorId);
	}

}
