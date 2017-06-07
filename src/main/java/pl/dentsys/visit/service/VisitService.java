package pl.dentsys.visit.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.dentsys.visit.api.TreatmentDict;
import pl.dentsys.visit.api.VisitDto;
import pl.dentsys.visit.api.VisitSimpleDto;
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
		visitEntity.setVisitDate(new Date());
		List<VisitTreatmentEntity> treatmentList=new ArrayList<>();
		for(TreatmentDict dict:visit.getTreatmentList()){
			VisitTreatmentEntity visitTreat=new VisitTreatmentEntity();
			visitTreat.setTreatmentId(dict.getId());
			visitTreat.setVisit(visitEntity);
			treatmentList.add(visitTreat);
		}
		visitEntity.setTreatmentList(treatmentList);
		visitRepo.save(visitEntity);
	}
	
	public VisitDto getVisit(Long id){
		
		VisitEntity entity=visitRepo.findOne(id);
		
		return visitAssembler.visitToDto(entity);
		
	}


}
