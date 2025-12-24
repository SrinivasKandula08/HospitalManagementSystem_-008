package com.cdgn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgn.exception.InvalidPatient;
import com.cdgn.model.Doctor;
import com.cdgn.model.Patient;
import com.cdgn.repository.PatientRepository;

@Service
public class PatientService {
	@Autowired
	private PatientRepository patientRepository;

	public Patient savePatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepository.save(patient);
	}

	public  Patient getPatient(Integer id) {
		// TODO Auto-generated method stub
		return patientRepository.findById(id).orElseThrow(()->new InvalidPatient("Invalid Patient ID"));
	}

	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		return patientRepository.findAll();
	}

	public Patient updatePatient(Integer id, Patient patient) {
		Patient response = getPatient(id);
		response.setName(patient.getName());
		response.setAge(patient.getAge());
		response.setGender(patient.getGender());
		response.setDisease(patient.getDisease());
		response.setFee(patient.getFee());
		response.setDoctor(patient.getDoctor());
		patientRepository.save(response);
		// TODO Auto-generated method stub
		return response;
	}

	public void deleteById(Integer id) {
		if(patientRepository.existsById(id)) {
			patientRepository.deleteById(id);
		}
		else {
			throw new InvalidPatient("Invalid Pateint.....");
		}
		// TODO Auto-generated method stub
		
	}
	

}
