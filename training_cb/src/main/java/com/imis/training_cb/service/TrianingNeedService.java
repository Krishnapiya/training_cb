package com.imis.training_cb.service;

import org.springframework.data.domain.Page;

import com.imis.training_cb.dto.TrainingNeedConfirmation;
import com.imis.training_cb.entity.TrainingNeed;

public interface TrianingNeedService {
	
TrainingNeedConfirmation SaveTrainingNeed(TrainingNeed trainingNeed);
TrainingNeedConfirmation GetLastTnaId();
Page<TrainingNeed> findPage(int pageNumber);
TrainingNeedConfirmation deleteTrainingNeed(String tnaId);

}
