package com.cdgn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdgn.model.Doctor;
import com.cdgn.model.Patient;
import com.cdgn.service.PatientService;

@RestController
@RequestMapping("/patient")
public class PatientController {
	@Autowired
	private PatientService patientservice;
	
	@PostMapping
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
		Patient response = patientservice.savePatient(patient);
		return new ResponseEntity<Patient>(response,HttpStatus.CREATED);

}
	@GetMapping("/{id}")
	public ResponseEntity<Patient> getPatient(@PathVariable Integer id){
		Patient response =patientservice.getPatient(id);
		return new ResponseEntity<Patient>(response,HttpStatus.FOUND);
	}
	@GetMapping
	public ResponseEntity<List<Patient>> findAll(){
		List<Patient> patients = patientservice.findAll();
	return new  ResponseEntity<List<Patient>>(patients,HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Integer id,@RequestBody Patient patient){
		Patient response = patientservice.updatePatient(id,patient);
		return new ResponseEntity<Patient>(response,HttpStatus.OK);
			
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePatient(@PathVariable Integer id,@RequestBody Patient patient){
		patientservice.deleteById(id);
		return new ResponseEntity<String>("deleted successfully",HttpStatus.OK);
	}
	
	
}
