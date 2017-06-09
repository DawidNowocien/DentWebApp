package pl.dentsys.visit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.dentsys.treatment.api.TreatmentDict;
import pl.dentsys.visit.api.PersonShort;
import pl.dentsys.visit.api.VisitDto;
import pl.dentsys.visit.domain.VisitEntity;
import pl.dentsys.visit.domain.VisitTreatmentEntity;

@Component
public class VisitDtoAssembler {
	
	public VisitDto visitToDto(VisitEntity entity){
		VisitDto dto=new VisitDto();

		PersonShort patient=new PersonShort(entity.getPatient().getId(),entity.getPatient().getName(),
				entity.getPatient().getSurname(),entity.getPatient().getPesel());
		dto.setVisitId(entity.getId());
		dto.setVisitDate(entity.getVisitDate());
		dto.setPatient(patient);
		List<TreatmentDict> treatmentList=new ArrayList<>();
		for(VisitTreatmentEntity treatment:entity.getTreatmentList()){
			TreatmentDict dict=new TreatmentDict();
			dict.setId(treatment.getTreatmentId());
			dict.setLabel(treatment.getTreatmentDict().getLabel());
			treatmentList.add(dict);
		}
		dto.setTreatmentList(treatmentList);
	
		return dto;
	}
	
	public List<VisitDto> visitToDtoList(List<VisitEntity> entityList){
		
		List<VisitDto> visitList=new ArrayList<>();
		
		for(VisitEntity entity:entityList){
			visitList.add(visitToDto(entity));
		}
				
		return visitList;		
	}

}
