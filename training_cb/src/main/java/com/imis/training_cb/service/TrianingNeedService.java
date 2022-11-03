package com.imis.training_cb.service;

import com.imis.training_cb.dto.TrainingNeedConfirmation;
import com.imis.training_cb.entity.TrainingNeed;

public interface TrianingNeedService {
	
TrainingNeedConfirmation SaveTrainingNeed(TrainingNeed trainingNeed);
TrainingNeedConfirmation GetLastTnaId();

}
