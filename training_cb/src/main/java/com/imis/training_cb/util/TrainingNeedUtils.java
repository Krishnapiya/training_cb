package com.imis.training_cb.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.domain.Page;

import com.imis.training_cb.Exception.NoDataFoundException;
import com.imis.training_cb.entity.TrainingNeed;
import com.imis.training_cb.repository.TrainingNeedRepository;

public class TrainingNeedUtils {
	
	public static boolean validateTnaID(TrainingNeed trainingNeed) {
		if(trainingNeed==null)
			throw new NoDataFoundException("Training needs cannot be found");
		else
		return true;
	
	}
	public static boolean validateTrainignNeedList(Page<TrainingNeed> trainingNeeds ) {
		if(trainingNeeds.getNumberOfElements()==0)
			throw new NoDataFoundException("Training need table is empty");
		else
		return true;
	
	}
	public static boolean validateDuplicateTNAId(TrainingNeed tna ) {
		if(tna==null)
			return true;
		else
			throw new DuplicateKeyException("Duplicate TNA id");
		
	
	}
}
