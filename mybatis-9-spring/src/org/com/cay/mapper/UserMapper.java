package org.com.cay.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.com.cay.entity.User;

public interface UserMapper {

	@Insert("insert into s_user(user_name,user_birthday,user_salary) values(#{user.name},#{user.birthday},#{user.salary})")
	@Options(useGeneratedKeys = true, keyProperty = "user.id") // 生成主键值并返回给user对象的id
	void save(@Param("user") User user);

	@Update("update s_user set user_name=#{user.name} where user_id=#{user.id}")
	void update(@Param("user") User user);

	@Delete("delete from s_user where user_id=#{id}")
	void delete(int id);

	@Select("select * from s_user where user_id=#{id}")
	@Results({ 
		@Result(id = true, property = "id", column = "user_id"),
		@Result(property = "name", column = "user_name"), 
		@Result(property = "birthday", column = "user_birthday"),
		@Result(property = "salary", column = "user_salary") })
	User findById(int id);

	@Select("select * from s_user")
	@ResultMap("UserMap")
	List<User> findAll();
}
