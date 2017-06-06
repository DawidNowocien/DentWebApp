package pl.dentsys.patient.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import pl.dentsys.patient.api.PatientSearchCriteria;

public class PatientSpecification implements Specification<PatientEntity>{
	
	private PatientSearchCriteria searchCriteria;
	
	public PatientSpecification(PatientSearchCriteria searchCriteria){
		this.searchCriteria=searchCriteria;
	}

	@Override
	public Predicate toPredicate(Root<PatientEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		
		List<Predicate> predicates=new ArrayList<>();
		
		if(searchCriteria.getName()!=null){
			predicates.add(cb.like(root.get("name"), "%"+searchCriteria.getName()+ "%"));
		}
		if(searchCriteria.getSurname()!=null){
			predicates.add(cb.like(root.get("surname"), "%"+searchCriteria.getSurname()+ "%"));
		}
		if(searchCriteria.getPesel()!=null){
			predicates.add(cb.equal(root.get("pesel"), searchCriteria.getPesel()));
		}
		
		
		return cb.and(predicates.toArray(new Predicate[0]));
	}
	

}
