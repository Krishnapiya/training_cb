package com.imis.training_cb.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeBatch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long employeeId;
	private Boolean confirmation;
	@ManyToOne(fetch = FetchType.LAZY)
	private TrainingBatch trainingBatch;
	private String feedBack;
	
	
}
