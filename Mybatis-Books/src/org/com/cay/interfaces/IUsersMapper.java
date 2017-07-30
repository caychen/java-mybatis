package org.com.cay.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.com.cay.entity.Users;

public interface IUsersMapper {

	@Select("select * from users where uid=#{uid}")
	public Users findUsersById(int uid);
	
	@Insert("insert into users(username,password) values(#{username},#{password})")
	public int insertUsers(Users users);
	
	@Update("update users set username=#{username} where uid=#{uid}")
	public int updateUsers(int uid, String newName);
	
	@Delete("delete from users where uid=#{uid}")
	public int deleteUsers(int uid);
	
	@Select("select * from users")
	public List<Users> findAll();
}
