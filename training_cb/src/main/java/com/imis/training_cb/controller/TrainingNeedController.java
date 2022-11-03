package com.imis.training_cb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.imis.training_cb.TrainingCbApplication;
import com.imis.training_cb.dto.TrainingNeedConfirmation;
import com.imis.training_cb.entity.TrainingNeed;
import com.imis.training_cb.service.TrianingNeedService;



@RestController
@RequestMapping("/training_cb")
public class TrainingNeedController {
	@Autowired
	private TrianingNeedService trainingNeedservice;
	private static final Logger logger = LoggerFactory.getLogger(TrainingCbApplication.class);
	@PostMapping("/saveTrainingData")
	public TrainingNeedConfirmation saveTrainingNeed(@RequestBody TrainingNeed trainingNeed) {
		logger.info("save request received for "+trainingNeed);
		return trainingNeedservice.SaveTrainingNeed(trainingNeed);
	}
	
	@GetMapping("/getTnaID")
	public TrainingNeedConfirmation getTnaId() {
		logger.info("Request to get last tna id received");
		return trainingNeedservice.GetLastTnaId();
	}

}
