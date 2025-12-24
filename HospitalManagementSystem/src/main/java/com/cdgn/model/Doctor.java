package com.cdgn.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer age;
	private String gender;
	private String email;
	private String specialization;
	private Double salary;
	private Integer experience;
	@OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
	@JsonIgnore
	@ToString.Exclude
	private List<Patient> patients;

}
