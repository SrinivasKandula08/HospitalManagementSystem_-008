package com.cdgn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdgn.model.Doctor;
import com.cdgn.service.DoctorService;
@RestController
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	private DoctorService doctorservice;
	@PostMapping
	public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor){
		Doctor response = doctorservice.saveDoctor(doctor);
		return new ResponseEntity<Doctor>(response,HttpStatus.CREATED);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Doctor> getDoctor(@PathVariable Integer id){
		Doctor response = doctorservice.getDoctor(id);
		return new ResponseEntity<Doctor>(response,HttpStatus.FOUND);
	}
	@GetMapping
	public ResponseEntity<List<Doctor>> findAll(){
		List<Doctor> doctors = doctorservice.findAll();
	return new  ResponseEntity<List<Doctor>>(doctors,HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable Integer id,@RequestBody Doctor doctor){
		Doctor response = doctorservice.updateDoctor(id,doctor);
		return new ResponseEntity<Doctor>(response,HttpStatus.OK);
		
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDoctor(@PathVariable Integer id,@RequestBody Doctor doctor){
		doctorservice.deleteById(id);
		return new ResponseEntity<String>("deleted successfully",HttpStatus.OK);
	}
	@GetMapping("/name/{name}")
	public ResponseEntity<Doctor> getByName(@PathVariable String name){
		Doctor response = doctorservice.getByName(name);
		return new ResponseEntity<Doctor>(response,HttpStatus.FOUND);
	}
	
	

}
