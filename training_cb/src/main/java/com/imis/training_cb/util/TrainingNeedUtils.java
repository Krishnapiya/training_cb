package com.imis.training_cb.util;

import com.imis.training_cb.Exception.NoDataFoundException;
import com.imis.training_cb.entity.TrainingNeed;

public class TrainingNeedUtils {
	public static boolean validateTnaID(TrainingNeed trainingNeed) {
		if(trainingNeed==null)
			throw new NoDataFoundException("Training need table is empty");
		else
		return true;
	
	}
}
