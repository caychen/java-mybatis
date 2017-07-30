package org.com.cay.test;


import java.util.Date;
import java.util.List;

import org.com.cay.entity.User;
import org.com.cay.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)//使用spring的测试框架
@ContextConfiguration("/beans.xml")//加载spring的配置文件beans.xml
public class SMTest {

	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void testInsert() {
		User user = new User(0, "tom", new Date(), 1234);
		userMapper.save(user);
	}
	
	@Test
	public void testUpdate(){
		User u = userMapper.findById(1);
		u.setName("Cay");
		userMapper.update(u);
	}
	
	@Test
	public void testDelete(){
		userMapper.delete(2);
	}
	
	@Test
	public void testAll(){
		List<User> all = userMapper.findAll();
		for (User user : all) {
			System.out.println(user);
		}
	}

}
