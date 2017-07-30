package org.com.cay.util;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtil {

	private static final String RESOURCE = "org/com/cay/map/mybatis-config.xml";
	private static SqlSessionFactory factory = null;
	
	static{
		try {
			factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(RESOURCE));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory(){
		return factory;
	}
	
	public static SqlSession getSqlSession(){
		return factory.openSession();
	}
	
	public static void closeSqlSession(SqlSession session){
		if(session != null){
			session.close();
		}
	}
}
