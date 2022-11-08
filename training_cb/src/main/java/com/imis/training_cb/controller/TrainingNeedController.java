package com.imis.training_cb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestBody;
import com.imis.training_cb.TrainingCbApplication;
import com.imis.training_cb.dto.TrainingNeedConfirmation;
import com.imis.training_cb.dto.TrainingNeedPage;
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
	
	@GetMapping("/TrainingNeeds")
	public TrainingNeedPage getAllPages(){
		logger.info("initial request to get trainign needs");
	    return getOnePage(1);
	}
	 @GetMapping("/TrainingNeeds/{pageNumber}")
	 public TrainingNeedPage getOnePage(@PathVariable("pageNumber") int currentPage){
		 Page<TrainingNeed>  trainingNeedPage = trainingNeedservice.findPage(currentPage);
	     int totalPages = trainingNeedPage.getTotalPages();
	     long totalItems = trainingNeedPage.getTotalElements();
	     List<TrainingNeed> trainingNeed = trainingNeedPage.getContent();
	     logger.info("Request to get"+currentPage +" received");
	     return new TrainingNeedPage(totalPages,totalItems,trainingNeed);
	 }
	 
	 @DeleteMapping("/deleteTrainingNeed/{id}")
	 public TrainingNeedConfirmation deleteTrainingNeed(@PathVariable("id") String id) {
		 logger.info("Request to delete "+id+ "received");
		 return trainingNeedservice.deleteTrainingNeed(id);
	 }

}
