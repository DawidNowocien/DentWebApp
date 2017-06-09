package pl.dentsys.doctor.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import pl.dentsys.doctor.api.DoctorSearchCriteria;

public class DoctorSpecification implements Specification<DoctorEntity>{
	
	private DoctorSearchCriteria searchCriteria;
	
	public DoctorSpecification(DoctorSearchCriteria searchCriteria){
		this.searchCriteria=searchCriteria;
	}

	@Override
	public Predicate toPredicate(Root<DoctorEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		
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
		if(searchCriteria.getSpecializationId()!=null){
			predicates.add(cb.equal(root.get("specializationId"), searchCriteria.getSpecializationId()));
		}
				
		return cb.and(predicates.toArray(new Predicate[0]));
	}
	

}
