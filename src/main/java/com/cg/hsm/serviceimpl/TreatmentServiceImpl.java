package com.cg.hsm.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.hsm.entity.Treatment;
import com.cg.hsm.entity.TreatmentStatus;
import com.cg.hsm.repository.ITreatmentRepository;
import com.cg.hsm.service.ITreatmentService;

@Service
public class TreatmentServiceImpl implements ITreatmentService {

	@Autowired
	ITreatmentRepository treatmentRepo;

//--------------------------POST----------------------------------------------------------	
	//save
	@Override
	public Treatment save(Treatment treatment) {
		return treatmentRepo.save(treatment);
	}

//---------------------GET----------------------------------------------------------	
	//findAllTreatment
	@Override
	public List<Treatment> findAllTreatment() {
		return treatmentRepo.findAll();
	}

	// findByTreatmentId
	@Override
	public Treatment findByTreatmentId(int treatmentId) {
		return treatmentRepo.findByTreatmentId(treatmentId);
	}

	// findByTreatmentDate
	@Override
	public List<Treatment> findByTreatmentDate(LocalDate treatmentDate) {
		return  treatmentRepo.findByTreatmentDate(treatmentDate);
	}
    
	// findByPatientCaseId
	@Override
	public Treatment findByPatientCaseId(int patientCaseId) {
		return treatmentRepo.findByPatientCaseId(patientCaseId);
	}
	
    //findByTreatmentStatus
	@Override
	public List<Treatment> findByTreatmentStatus(TreatmentStatus treatmentStatus) {
		return treatmentRepo.findByTreatmentStatus(treatmentStatus);
		 
	} 


// ---------------DELETE----------------------------------------------------------------------	
	@Override
	public Treatment deleteTreatmentByTreatmentId(int treatmentId) {
		Optional<Treatment> opt = treatmentRepo.findById(treatmentId);
		if (!opt.isPresent()) {
			return null;
		}
		Treatment t = opt.get();
		treatmentRepo.deleteById(treatmentId);
		return t;
	}
	
	
// ---------------UPDATE----------------------------------------------------------------------	
	//updateAll
	@Override
	public Treatment updateTreatment(Treatment treatment) {
		Treatment t = treatmentRepo.findByTreatmentId(treatment.getTreatmentId());
		t.setCurrentTreatment(treatment.getCurrentTreatment());
		t.setPatientCaseId(treatment.getPatientCaseId());
		t.setTreatmentDate(treatment.getTreatmentDate());
		t.setTreatmentFee(treatment.getTreatmentFee());
		t.setTreatmentId(treatment.getTreatmentId());
		return treatmentRepo.save(t);
	}
	
	//update TreatmentDateByTreatmentId
	@Override
	public Treatment updateTreatmentDateByTreatmentId(int treatmentId,Treatment treatment) {
		Treatment t= treatmentRepo.findByTreatmentId(treatmentId);
		t.setTreatmentDate(treatment.getTreatmentDate());
		return treatmentRepo.save(t);
	}

	@Override
		public Treatment updateTreatmentStatusByTreatmentId(int treatmentId,Treatment treatment) {
			Treatment t= treatmentRepo.findByTreatmentId(treatmentId);
			t.setTreatmentStatus(treatment.getTreatmentStatus());
			return treatmentRepo.save(t);
	}
}