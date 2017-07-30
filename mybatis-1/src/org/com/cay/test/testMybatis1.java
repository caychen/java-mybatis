package org.com.cay.test;

import org.apache.ibatis.session.SqlSession;
import org.com.cay.entity.User;
import org.com.cay.util.MybatisUtil;
import org.junit.Test;

public class testMybatis1 {

	@Test
	public void test() {
		
		SqlSession session = MybatisUtil.getFactory().openSession();
		
		User user = session.selectOne("getUser", 1);
		System.out.println(user);
		
		session.close();
	}

}
