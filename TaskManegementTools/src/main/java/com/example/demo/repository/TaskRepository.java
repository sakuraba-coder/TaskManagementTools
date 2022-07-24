package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.model.Task;

@Mapper
public interface TaskRepository {

    @Select("select * from tasks")
    List<Task> findAll();

    @Select("select * from tasks where id = #{id}")
    Task find(String id);

    @Update("update tasks SET kind = #{kind}, name = #{name}, entry_date = #{entryDate}, complete_date = #{completeDate}, checked = #{checked} where id = #{id}")
	void update(@Param("id") Integer id, @Param("kind") Integer kind, @Param("name") String name, @Param("entryDate") Date entryDate, @Param("completeDate") Date compelteDate, @Param("checked") Integer checked);
}
