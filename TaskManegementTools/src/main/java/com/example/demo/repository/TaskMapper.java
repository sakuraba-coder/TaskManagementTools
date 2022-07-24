package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.model.Condition;
import com.example.demo.domain.model.Kind;
import com.example.demo.domain.model.Task;

@Mapper
public interface TaskMapper {

//    @Select("select * from tasks")
    List<Task> findAll();

//    @Select("select * from tasks where id = #{id}")
    Task find(String id);

//    @Update("update tasks SET kind = #{kind}, name = #{name}, entry_date = #{entryDate}, complete_date = #{completeDate}, checked = #{checked} where id = #{id}")
//	void update(@Param("id") Integer id, @Param("name") String name, @Param("completeDate") Date compelteDate, @Param("conditionId") Integer conditionId);
    void update(Task task);

	int insert(Task task);

	int insertLog(Task task);

	void delete(String id);

	List<Condition> getConditions();

	Condition getCondition(int id);

	List<Kind> getKinds();

}
