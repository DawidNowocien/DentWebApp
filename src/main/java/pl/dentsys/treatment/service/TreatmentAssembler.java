package pl.dentsys.treatment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.dentsys.treatment.api.TreatmentDict;
import pl.dentsys.treatment.domain.TreatmentDictEntity;

@Component
public class TreatmentAssembler {
	
	
	public TreatmentDict treatmentDictToDto(TreatmentDictEntity entity){
		
		TreatmentDict dict=new TreatmentDict();
		dict.setId(entity.getId());
		dict.setLabel(entity.getLabel());
		return dict;
		
	}

	public List<TreatmentDict> treatmentDictToDtoList(List<TreatmentDictEntity> entityList){
		
		List<TreatmentDict> dtoList=new ArrayList<>();
		for(TreatmentDictEntity entity:entityList){
			dtoList.add(treatmentDictToDto(entity));
		}
		
		return dtoList;
		
	}
}
