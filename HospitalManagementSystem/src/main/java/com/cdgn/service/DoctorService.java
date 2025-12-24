package com.cdgn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdgn.exception.InvalidDoctor;
import com.cdgn.model.Doctor;
import com.cdgn.repository.DoctorRepository;
import com.cdgn.repository.PatientRepository;
@Service
public class DoctorService {
	@Autowired
	private DoctorRepository doctorRepository;

	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	public Doctor getDoctor(Integer id) {
		// TODO Auto-generated method stub
		return doctorRepository.findById(id).orElseThrow(()->new InvalidDoctor("Invalid Doctor ID"));
	}

	public List<Doctor> findAll() {
		// TODO Auto-generated method stub
		return doctorRepository.findAll();
	}

	public Doctor updateDoctor(Integer id, Doctor doctor) {
		
		Doctor response = getDoctor(id);
			response.setName(doctor.getName());
			response.setEmail(doctor.getEmail());
			response.setExperience(doctor.getExperience());
			response.setAge(doctor.getAge());
			response.setGender(doctor.getGender());
			response.setSpecialization(doctor.getSpecialization());
			response.setSalary(doctor.getSalary());
			doctorRepository.save(response);
			return response;
	}
	public void deleteById(Integer id) {
		if(doctorRepository.existsById(id)) {
			doctorRepository.deleteById(id);
		}
		else {
			throw new InvalidDoctor("Invalid Doctor"); 
		}
		
	}

	public Doctor getByName(String name) {
		return doctorRepository.findByName(name).orElseThrow(()->new InvalidDoctor("InvalidDoctor name"));
		
	}

}