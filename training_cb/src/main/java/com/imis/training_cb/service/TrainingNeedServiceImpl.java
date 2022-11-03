package com.imis.training_cb.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imis.training_cb.TrainingCbApplication;
import com.imis.training_cb.dto.TrainingNeedConfirmation;
import com.imis.training_cb.entity.TrainingNeed;
import com.imis.training_cb.repository.TrainingNeedRepository;
import com.imis.training_cb.util.TrainingNeedUtils;

@Service
public class TrainingNeedServiceImpl implements TrianingNeedService {
	@Autowired
	private TrainingNeedRepository trainingNeedRepo;
	private static final Logger logger = LoggerFactory.getLogger(TrainingCbApplication.class);

	@Override
	@Transactional
	public TrainingNeedConfirmation SaveTrainingNeed(TrainingNeed trainingNeed) {
		TrainingNeed newNeed = trainingNeedRepo.save(trainingNeed);
		logger.info("New Training need added" + newNeed.getTnaId());
		return new TrainingNeedConfirmation("success", newNeed.getTnaId());
	}

	@Override
	public TrainingNeedConfirmation GetLastTnaId() {
		TrainingNeed trainNeed = trainingNeedRepo.findTopByOrderByIdDesc();
		TrainingNeedUtils.validateTnaID(trainNeed);
		logger.info("The latest training need id is " + trainNeed.getTnaId());
		return new TrainingNeedConfirmation("success", trainNeed.getTnaId());
	}

}
