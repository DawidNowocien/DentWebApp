package pl.dentsys.treatment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dentsys.treatment.api.TreatmentDict;
import pl.dentsys.treatment.domain.TreatmentDictEntity;
import pl.dentsys.treatment.domain.TreatmentRepository;

@Service
public class TreatmentService {
	
	@Autowired
	private TreatmentRepository TreatmentRepo;
	
	@Autowired
	private TreatmentAssembler treatmentAssembler;
	
	public List<TreatmentDict> getTreatmentDict(){
		
		List<TreatmentDictEntity> entityList=TreatmentRepo.findAll();
		
		return treatmentAssembler.treatmentDictToDtoList(entityList);
	}
	
	public TreatmentDict getSingleTreatment(Long treatmentId){
		
		TreatmentDictEntity entity=TreatmentRepo.findOne(treatmentId);
		
		return treatmentAssembler.treatmentDictToDto(entity);
	}

}
