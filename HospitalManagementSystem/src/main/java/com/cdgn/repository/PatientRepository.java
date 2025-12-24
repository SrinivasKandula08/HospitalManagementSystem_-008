package com.cdgn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdgn.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
