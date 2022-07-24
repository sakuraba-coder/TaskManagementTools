package com.example.demo.domain.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Task {
	private int id;
	private int kindId;
	private String name;
	private Date entryDate;
	private Date completeDate;
	private int conditionId;

	private Kind kind;
	private Condition condition;

	private String memo;

	private List<UpdateLog> updateLogList;
}
