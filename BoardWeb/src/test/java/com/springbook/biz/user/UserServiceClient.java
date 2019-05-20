package com.springbook.biz.user;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.user.service.UserService;
import com.springbook.biz.user.vo.UserVO;

public class UserServiceClient {
	public static void main(String[] args) {
//		// 1. Spring �����̳ʸ� �����Ѵ�.
//		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
//
//		// 2. Spring �����̳ʷκ��� UserServiceImpl ��ü�� Lookup �Ѵ�.
//		UserService userService = (UserService) container.getBean("userService");
//
//		// 3. �α��� ��� �׽�Ʈ
//		UserVO vo = new UserVO();
//		vo.setId("test");
//		vo.setPassword("test123");
//
//		UserVO user = userService.getUser(vo);
//		if (user != null) {
//			System.out.println(user.getName() + "�� ȯ���մϴ�.");
//		} else {
//			System.out.println("�α��� ����");
//		}
//
//		// 4. Spring �����̳ʸ� �����Ѵ�.
//		container.close();
		
		Set<String> treeSet = new TreeSet<String>();
		
		treeSet.add("1");
		treeSet.add("3");
		treeSet.add("2");
		treeSet.add("4");
		
		Iterator i = treeSet.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
}