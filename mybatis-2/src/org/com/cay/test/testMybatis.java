package org.com.cay.test;

import org.apache.ibatis.session.SqlSession;
import org.com.cay.entity.User;
import org.com.cay.interfaces.IUserMapper;
import org.com.cay.util.MybatisUtil;
import org.junit.Test;

public class testMybatis {

	@Test
	public void testAdd() {
		SqlSession session = MybatisUtil.getFactory().openSession(true);
		
		//����Ϊ�ӿڵ�����
		IUserMapper mapper = session.getMapper(IUserMapper.class);
		
		int ret = mapper.addUser(new User(-1, "Cay", 20));
		System.out.println(ret);
		session.close();
	}

}
