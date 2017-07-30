package org.com.cay.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.com.cay.entity.User;
import org.com.cay.util.MybatisUtil;
import org.junit.Test;

/**
 * ���Ի��棬session����Ļ���
 * 1��һ������
 * 	���һ������ķ�ʽ��
 * 		1.1��ִ��session.clearCache()�������
 *		1.2��ִ��CUD����
 *		1.3��session����һ�£���ʹ��session����֮��ر���session
 *
 * 2���������棬mapper����Ļ��棬��ֻ��ͬһ��namespace
 *	ʹ�ö������棬ʵ������Ҫʵ�����л�
 */
public class testMybatisCache {

	@Test
	//����һ������
	public void testCache1() {
		SqlSession session = MybatisUtil.getFactory().openSession();
		
		User user = session.selectOne("getUser", 1);
		System.out.println(user);
		
		user = session.selectOne("getUser", 1);
		System.out.println(user);
		System.out.println("-------------------");
		
		//1��ִ��clearCache()�����������
//		session.clearCache();
//		user = session.selectOne("getUser", 1);
//		System.out.println(user);
		
		//2��ִ��CUD����
		session.update("updateUser", new User(1, "Tom", 20));
		session.commit();
		user = session.selectOne("getUser", 1);
		System.out.println("CUD:" + user);
		
		session.close();
	}
	
	@Test
	//���Զ�������
	public void testCache2() {
		SqlSessionFactory factory = MybatisUtil.getFactory();
		SqlSession session1 = factory.openSession();
		SqlSession session2 = factory.openSession();
		
		User user = session1.selectOne("getUser", 1);
		session1.commit();//���ʣ�
		System.out.println("user1:" + user);
		
		user = session2.selectOne("getUser", 1);
		session2.commit();
		System.out.println("user2:" + user);
		
		session1.close();
		session2.close();
	}

}
