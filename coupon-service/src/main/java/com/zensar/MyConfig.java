package com.zensar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class MyConfig {

	@Value("${test.mytraining}")
	private String training;

	public String getTraining() {
		return training;
	}

	public void setTraining(String training) {
		this.training = training;
	}

}
