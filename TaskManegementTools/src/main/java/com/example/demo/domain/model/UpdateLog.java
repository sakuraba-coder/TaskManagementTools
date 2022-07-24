package com.example.demo.domain.model;

import java.util.Date;

import lombok.Data;

@Data
public class UpdateLog {

	private int id;
	private String name;
	private int conditionId;
	private String condition;
	private Date updateDate;
	private String memo;

}
