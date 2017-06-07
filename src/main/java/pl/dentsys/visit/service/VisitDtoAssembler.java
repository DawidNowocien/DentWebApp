package pl.dentsys.visit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.dentsys.visit.api.VisitDto;
import pl.dentsys.visit.domain.VisitEntity;

@Component
public class VisitDtoAssembler {
	
	public VisitDto visitToDto(VisitEntity entity){
		VisitDto dto=new VisitDto();
		
	
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
