package com.example.demo.form;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.domain.model.Condition;
import com.example.demo.domain.model.Kind;
import com.example.demo.domain.model.UpdateLog;

import lombok.Data;

@Data
public class TaskDetailForm {

	private int id;
	private Kind kind;
	@NotBlank
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date entryDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date completeDate;

//	@NotBlank//(message = "nullはあかんやろ")
	private Condition condition;
	private int conditionId;

	private String memo;

	private List<UpdateLog> updateLogList;
}
