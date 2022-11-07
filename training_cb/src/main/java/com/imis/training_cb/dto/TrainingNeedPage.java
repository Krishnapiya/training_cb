package com.imis.training_cb.dto;

import java.util.List;

import com.imis.training_cb.entity.TrainingNeed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainingNeedPage {
	private int totalPages;
	private long totalelements;
	 private List<TrainingNeed> trainingNeeds;

}
