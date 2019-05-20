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
//		// 1. Spring 컨테이너를 구동한다.
//		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
//
//		// 2. Spring 컨테이너로부터 UserServiceImpl 객체를 Lookup 한다.
//		UserService userService = (UserService) container.getBean("userService");
//
//		// 3. 로그인 기능 테스트
//		UserVO vo = new UserVO();
//		vo.setId("test");
//		vo.setPassword("test123");
//
//		UserVO user = userService.getUser(vo);
//		if (user != null) {
//			System.out.println(user.getName() + "님 환영합니다.");
//		} else {
//			System.out.println("로그인 실패");
//		}
//
//		// 4. Spring 컨테이너를 종료한다.
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