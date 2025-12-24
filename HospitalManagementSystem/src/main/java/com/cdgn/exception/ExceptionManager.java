package com.cdgn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionManager {
	@ExceptionHandler(InvalidDoctor.class)
	public ResponseEntity<String> doctorValidate(InvalidDoctor doctor){
		return new ResponseEntity<String>(doctor.getMessage(),HttpStatus.NOT_FOUND);
	}
	
		@ExceptionHandler(InvalidPatient.class)
		public ResponseEntity<String> patientValidate(InvalidPatient patient){
			return new ResponseEntity<String>(patient.getMessage(),HttpStatus.NOT_FOUND);
		}
	
}
