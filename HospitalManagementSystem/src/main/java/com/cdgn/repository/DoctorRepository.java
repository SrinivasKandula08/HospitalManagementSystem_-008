package com.cdgn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdgn.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	public Optional<Doctor> findByName(String name);

}
