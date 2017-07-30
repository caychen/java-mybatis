package org.com.cay.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.com.cay.entity.User;
import org.com.cay.util.MybatisUtil;
import org.junit.Test;

public class testMybatis2 {

	@Test
	public void testAdd() {
		/*
		 * 默认是手动提交事务，
		 * 1、openSession(true);让session自动提交
		 * 2、session = openSession();
		 * 	session.commit();//手动提交
		 */
		SqlSession session = MybatisUtil.getFactory().openSession();
		User user = new User(-1, "Cay", 20);
		int insert = session.insert("addUser", user);
		System.out.println(insert);
		
		//提交
		session.commit();
		
		session.close();
	}
	
	@Test
	public void testUpdate(){
		SqlSession session = MybatisUtil.getFactory().openSession();
		User user = new User(5, "Amy", 19);
		int update = session.update("updateUser", user);
		System.out.println(update);
		session.commit();
		
		session.close();
	}

	@Test
	public void testDelete(){
		SqlSession session = MybatisUtil.getFactory().openSession(true);
		int delete = session.delete("deleteUser", 5);
		System.out.println(delete);
		//session.commit();
		session.close();
	}
	
	@Test
	public void testAll(){
		SqlSession session = MybatisUtil.getFactory().openSession(true);
		
		List<User> selectList = session.selectList("getAllUsers");
		session.close();
		
		System.out.println(selectList);
	}
}
