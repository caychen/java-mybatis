package org.com.cay.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.com.cay.entity.User;

public interface IUserMapper {

	@Insert("insert into user(name, age) values(#{name}, #{age})")
	public int addUser(User user);
	
	@Delete("delete from user where id = #{id}")
	public int deleteById(int id); 
	
	@Update("update user set name = #{name}, age = #{age} where id = #{id}")
	public int update(User user);
	
	@Select("select * from user where id = #{id}")
	public User getById(int id);
	
	@Select("select * from user")
	public List<User> getAll();
}
