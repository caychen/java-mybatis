package org.com.cay.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {

	private final static String RESOURCE = "mybatis-config.xml";

	public static SqlSessionFactory getFactory() {
		InputStream is = MybatisUtil.class.getClassLoader().getResourceAsStream(RESOURCE);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		return factory;
	}
}
