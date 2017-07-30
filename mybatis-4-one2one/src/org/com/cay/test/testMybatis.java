package org.com.cay.test;


import org.apache.ibatis.session.SqlSession;
import org.com.cay.entity.Classes;
import org.com.cay.util.MybatisUtil;
import org.junit.Test;

public class testMybatis {

	@Test
	public void test1() {
		SqlSession session = MybatisUtil.getFactory().openSession();
		Classes c = session.selectOne("getClasses1", 2);
		System.out.println(c);
		session.close();
	}
	
	@Test
	public void test2() {
		SqlSession session = MybatisUtil.getFactory().openSession();
		Classes c = session.selectOne("getClasses2", 2);
		System.out.println(c);
		session.close();
	}

}
