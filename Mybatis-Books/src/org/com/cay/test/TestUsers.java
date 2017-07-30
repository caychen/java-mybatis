package org.com.cay.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.com.cay.entity.Users;
import org.com.cay.util.SqlSessionFactoryUtil;
import org.junit.Before;
import org.junit.Test;

public class TestUsers {

	private SqlSessionFactory factory = null;
	
	@Before
	public void before() throws Exception {
		factory = SqlSessionFactoryUtil.getSqlSessionFactory();
	}

	@Test
	public void testSelect() {
		SqlSession session = factory.openSession();
		Users users = session.selectOne("findUsersById", 3);
		System.out.println(users);
		SqlSessionFactoryUtil.closeSqlSession(session);
	}
	
	@Test
	public void testInsert(){
		SqlSession session = factory.openSession();
		Users users = new Users();
		users.setUsername("Kitty");
		users.setPassword("111111");
		session.selectOne("insertUsers",users);
		SqlSessionFactoryUtil.closeSqlSession(session);
	}
	
	@Test
	public void testUpdate(){
		SqlSession session = factory.openSession();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", "Tom");
		params.put("uid", 3);
		session.selectOne("updateUsers", params);
		SqlSessionFactoryUtil.closeSqlSession(session);		
	}
	
	@Test
	public void testDelete(){
		SqlSession session = factory.openSession();
		session.selectOne("deleteUsers", 3);
//		System.out.println(rows);
		SqlSessionFactoryUtil.closeSqlSession(session);
	}
	
	@Test
	public void testAll(){
		SqlSession session = factory.openSession();
		List<Users> list = session.selectList("findAll");
		System.out.println(list.size());
		list.forEach((users) -> {System.out.println(users);});
		SqlSessionFactoryUtil.closeSqlSession(session);
	}

}
