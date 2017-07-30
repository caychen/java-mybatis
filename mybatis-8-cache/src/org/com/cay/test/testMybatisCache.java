package org.com.cay.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.com.cay.entity.User;
import org.com.cay.util.MybatisUtil;
import org.junit.Test;

/**
 * 测试缓存，session级别的缓存
 * 1、一级缓存
 * 	清除一级缓存的方式：
 * 		1.1、执行session.clearCache()清除缓存
 *		1.2、执行CUD操作
 *		1.3、session对象不一致，即使用session两次之间关闭了session
 *
 * 2、二级缓存，mapper级别的缓存，即只在同一个namespace
 *	使用二级缓存，实体类需要实现序列化
 */
public class testMybatisCache {

	@Test
	//测试一级缓存
	public void testCache1() {
		SqlSession session = MybatisUtil.getFactory().openSession();
		
		User user = session.selectOne("getUser", 1);
		System.out.println(user);
		
		user = session.selectOne("getUser", 1);
		System.out.println(user);
		System.out.println("-------------------");
		
		//1、执行clearCache()，来清除缓存
//		session.clearCache();
//		user = session.selectOne("getUser", 1);
//		System.out.println(user);
		
		//2、执行CUD操作
		session.update("updateUser", new User(1, "Tom", 20));
		session.commit();
		user = session.selectOne("getUser", 1);
		System.out.println("CUD:" + user);
		
		session.close();
	}
	
	@Test
	//测试二级缓存
	public void testCache2() {
		SqlSessionFactory factory = MybatisUtil.getFactory();
		SqlSession session1 = factory.openSession();
		SqlSession session2 = factory.openSession();
		
		User user = session1.selectOne("getUser", 1);
		session1.commit();//疑问？
		System.out.println("user1:" + user);
		
		user = session2.selectOne("getUser", 1);
		session2.commit();
		System.out.println("user2:" + user);
		
		session1.close();
		session2.close();
	}

}
