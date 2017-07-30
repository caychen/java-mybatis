package org.com.cay.test;


import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.com.cay.util.MybatisUtil;
import org.junit.Test;

public class testMybatis {

	@Test
	public void test1() {
		SqlSession session = MybatisUtil.getFactory().openSession();
		
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("sexid", 1);
		paramMap.put("userCount", -1);
		session.selectOne("getUserCount1", paramMap);
		Integer count = paramMap.get("userCount");
		System.out.println(count);
		session.close();
	}
	
	@Test
	public void test2() {
		SqlSession session = MybatisUtil.getFactory().openSession();
		
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("sexid", 1);
		paramMap.put("userCount", -1);
		session.selectOne("getUserCount2", paramMap);
		Integer count = paramMap.get("userCount");
		System.out.println(count);
		session.close();
	}
	

}
