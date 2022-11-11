package com.imis.training_cb.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.imis.training_cb.TrainingCbApplication;
import com.imis.training_cb.Exception.GenericException;
import com.imis.training_cb.dto.TrainingNeedConfirmation;
import com.imis.training_cb.entity.TrainingNeed;
import com.imis.training_cb.repository.TrainingNeedRepository;
import com.imis.training_cb.util.TrainingNeedUtils;
import org.springframework.beans.factory.annotation.*;
import lombok.Value;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
@PropertySource("classpath:messages.properties")
@Service
public class TrainingNeedServiceImpl implements TrianingNeedService {
	@Autowired
	private TrainingNeedRepository trainingNeedRepo;
	private static final Logger logger = LoggerFactory.getLogger(TrainingCbApplication.class);
   @org.springframework.beans.factory.annotation.Value(value = "${TRAINING_NEED_CONFIRMATION.SUCCESS}")
	private String successMessage;
   @org.springframework.beans.factory.annotation.Value(value = "${TRAINING_NEED_CONFIRMATION.SUCCESS}")
	private String deleteMessage;
	@Override
	@Transactional
	public TrainingNeedConfirmation SaveTrainingNeed(TrainingNeed trainingNeed) {
		try {
			TrainingNeed need = trainingNeedRepo.findByTnaId(trainingNeed.getTnaId());
			TrainingNeedUtils.validateDuplicateTNAId(need);
			TrainingNeed newNeed = trainingNeedRepo.save(trainingNeed);
			logger.info("New Training need added" + newNeed.getTnaId());
			return new TrainingNeedConfirmation(successMessage, newNeed.getTnaId());
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GenericException("An error occured whie processing the request");
		}
	}

	@Override
	public TrainingNeedConfirmation GetLastTnaId() {
		try {
			TrainingNeed trainNeed = trainingNeedRepo.findTopByOrderByIdDesc();
			TrainingNeedUtils.validateTnaID(trainNeed);
			logger.info("The latest training need id is " + trainNeed.getTnaId());
			return new TrainingNeedConfirmation(successMessage, trainNeed.getTnaId());
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GenericException("An error occured whie processing the request");
		}
	}

	@Override
	public Page<TrainingNeed> findPage(int pageNumber) {
		// TODO Auto-generated method stub
		try {
			Sort sort = Sort.by("priority");
			Pageable pageable = PageRequest.of(pageNumber - 1, 6, sort);
			Page<TrainingNeed> trainingNeed = trainingNeedRepo.findAll(pageable);
			TrainingNeedUtils.validateTrainignNeedList(trainingNeed);
			logger.info("The count of training need list is" + trainingNeed.getNumberOfElements());
			return trainingNeed;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GenericException("An error occured whie processing the request");
		}

	}

	@Override
	@Transactional
	public TrainingNeedConfirmation deleteTrainingNeed(String id) {
		try {
			TrainingNeed trainingNeed = trainingNeedRepo.findByTnaId(id);
			TrainingNeedUtils.validateTnaID(trainingNeed);
			trainingNeedRepo.deleteByTnaId(id);
			return new TrainingNeedConfirmation(deleteMessage, id.toString());
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new GenericException("An error occured whie processing the request");
		}
	}

}
