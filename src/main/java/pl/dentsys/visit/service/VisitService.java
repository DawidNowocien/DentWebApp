package pl.dentsys.visit.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.dentsys.visit.api.VisitDto;
import pl.dentsys.visit.api.VisitSearchCriteria;
import pl.dentsys.visit.api.VisitSimpleDto;
import pl.dentsys.visit.domain.QueryParameters;
import pl.dentsys.visit.domain.VisitEntity;
import pl.dentsys.visit.domain.VisitRepository;
import pl.dentsys.visit.domain.VisitTreatmentEntity;

@Component
public class VisitService {
	
	@Autowired
	private VisitRepository visitRepo;
	
	@Autowired
	private VisitDtoAssembler visitAssembler;
	
	public void addVisit(VisitSimpleDto visit){
		
		VisitEntity visitEntity=new VisitEntity();
		visitEntity.setDoctorId(visit.getDoctorId());
		visitEntity.setPatientId(visit.getPatientId());
		visitEntity.setVisitDate(visit.getVisitDate());
		List<VisitTreatmentEntity> treatmentList=new ArrayList<>();
		
		if(visit.getTreatmentList()!=null){
			for(Long treatmentId:visit.getTreatmentList()){
				VisitTreatmentEntity visitTreat=new VisitTreatmentEntity();
				visitTreat.setTreatmentId(treatmentId);
				visitTreat.setVisit(visitEntity);
				treatmentList.add(visitTreat);
			}
		}

		visitEntity.setTreatmentList(treatmentList);
		visitRepo.save(visitEntity);
	}
	
	public VisitDto getVisit(Long id){
		
		VisitEntity entity=visitRepo.findOne(id);
		
		return visitAssembler.visitToDto(entity);
		
	}

	public List<VisitDto> searchVisit(VisitSearchCriteria searchCriteria){
	
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDateTime dateFrom = LocalDateTime.parse(searchCriteria.getDateFrom(), formatter);
        LocalDateTime dateTo = LocalDateTime.parse(searchCriteria.getDateTo(), formatter);
        QueryParameters param=new QueryParameters(dateFrom,dateTo,
        		searchCriteria.getDoctorId(),searchCriteria.getPatientId());
		
		List<VisitEntity> visitEntityList=new ArrayList<>();
		
		if(searchCriteria.getPatientId()!=null)
			visitEntityList=visitRepo.findVisitsByDoctorAndPatientidAndDates(param);
		else
			visitEntityList=visitRepo.findVisitsByDoctorAndDates(param);
		
		
		return visitAssembler.visitToDtoList(visitEntityList);
		
	}
	
	public void updateVisit(VisitSimpleDto visit,Long visitId){
		
		VisitEntity visitEntity=visitRepo.findOne(visitId);
		visitEntity.setDoctorId(visit.getDoctorId());
		visitEntity.setPatientId(visit.getPatientId());
		visitEntity.setVisitDate(visit.getVisitDate());
		visitEntity.getTreatmentList().clear();
		
		if(visit.getTreatmentList()!=null){
			for(Long treatmentId:visit.getTreatmentList()){
				VisitTreatmentEntity visitTreat=new VisitTreatmentEntity();
				visitTreat.setTreatmentId(treatmentId);
				visitTreat.setVisit(visitEntity);
				visitEntity.getTreatmentList().add(visitTreat);
			}
		}

		visitRepo.saveAndFlush(visitEntity);
	}
	
	public void deleteVisit(Long visitId){
		visitRepo.delete(visitId);
	}

	
}
