package com.imis.training_cb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imis.training_cb.entity.TrainingNeed;

public interface TrainingNeedRepository extends JpaRepository<TrainingNeed, Long>{
	TrainingNeed findTopByOrderByIdDesc();
	TrainingNeed findByTnaId(String tnaID);	
	void deleteByTnaId(String tnaID);
}
