package com.api.response.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CreateJobResponse {
	String message;
	CreateJobRespData data;

}
