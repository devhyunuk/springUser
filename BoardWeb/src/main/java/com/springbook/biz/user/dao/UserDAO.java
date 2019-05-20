package com.springbook.biz.user.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.vo.UserVO;

// DAO(Data Access Object)
@Repository
public class UserDAO {
	@Autowired
	private SqlSessionTemplate mybatis;	
	
	// ȸ�� ���
	public UserVO getUser(UserVO vo) {
		System.out.println("#@ START DAO getUser :" + vo);
		System.out.println("#@ mybatis :" + mybatis);
		
		UserVO res = null;
		try {
			System.out.println("#@ ===> Mybatis�� getUser() ��� ó��");
			res = (UserVO) mybatis.selectOne("UserDAO.getUser", vo);
		} catch (Exception e) {
			System.out.println("#@ Exception e :" + e);
		}
		
		System.out.println("#@ res :" + res);
		
		return res;
	}
}