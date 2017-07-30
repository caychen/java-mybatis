package org.com.cay.test;

import org.apache.ibatis.session.SqlSession;
import org.com.cay.entity.Order;
import org.com.cay.util.MybatisUtil;
import org.junit.Test;

public class testOrder {

	@Test
	public void test1() {
		SqlSession session = MybatisUtil.getFactory().openSession();
		
		Order order = session.selectOne("getOrder1", 1);
		System.out.println(order);
		session.close();
	}
	
	@Test
	public void test2() {
		SqlSession session = MybatisUtil.getFactory().openSession();
		
		Order order = session.selectOne("getOrder2", 1);
		System.out.println(order);
		session.close();
	}
	
	@Test
	public void test3() {
		SqlSession session = MybatisUtil.getFactory().openSession();
		
		Order order = session.selectOne("getOrder3", 1);
		System.out.println(order);
		session.close();
	}

}
