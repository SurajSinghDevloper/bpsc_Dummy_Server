package com.bpsc.app.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Eductation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long EductationId;
}
