package com.cg.hsm.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.hsm.entity.Treatment;
import com.cg.hsm.entity.TreatmentStatus;

public interface ITreatmentService {

	/*
	 * +findAllTreatent() +saveTreatment() +findByTreatmentId() +findByDocName()
	 * +findByDate() +deleteTreatmentByTreatmentId() +updateTreatment()
	 */
//----------------------POST------------------------------------------------------------
	// save
	Treatment save(Treatment treatment);

//----------------------GET--------------------------------------------------
	// findAllTreatmentDetails
	List<Treatment> findAllTreatment();

	// findByPatientCaseId
	Treatment findByPatientCaseId(int patientCaseId);

	// findByTreatmentId
	Treatment findByTreatmentId(int treatmentId);

	// findByTreatmentDate
	List<Treatment> findByTreatmentDate(LocalDate treatmentDate);
	
	//findByTreatmentStatus
	List<Treatment> findByTreatmentStatus(TreatmentStatus treatmentStatus); 
	
//--------------------DELETE------------------------------------------------------
	// deleteTreatmentByTreatmentId
	Treatment deleteTreatmentByTreatmentId(int treatmentId);

//-------------------UPDATE-------------------------------------------------------
	// updateTreatment
	Treatment updateTreatment(Treatment treatment);
    
	//updateTreatmentDateByTreatmentId
	Treatment updateTreatmentDateByTreatmentId(int treatmentId, Treatment treatment);
	
	//updateTreatmentStatusByTreatmentId
	Treatment updateTreatmentStatusByTreatmentId(int treatmentId, Treatment treatment);
}
