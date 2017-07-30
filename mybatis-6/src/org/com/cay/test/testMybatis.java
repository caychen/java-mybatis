package org.com.cay.test;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.com.cay.entity.ConditionUser;
import org.com.cay.entity.User;
import org.com.cay.util.MybatisUtil;
import org.junit.Test;

public class testMybatis {

	@Test
	public void test1() {
		SqlSession session = MybatisUtil.getFactory().openSession();
		String name = "o";
		ConditionUser cu = new ConditionUser("%" + name + "%", 13, 19);
		List<User> users = session.selectList("getUser1", cu);
		System.out.println("first: " + users);
		
		name = null;
		cu.setName(name);
		users = session.selectList("getUser1", cu);
		System.out.println("second: " + users);
		session.close();
	}

}
