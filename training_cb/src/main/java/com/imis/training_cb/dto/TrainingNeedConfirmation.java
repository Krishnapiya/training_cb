package com.imis.training_cb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingNeedConfirmation {
	private String status;
	private String tnaId;
}
