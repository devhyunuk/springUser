package com.springbook.biz.user.service;

import com.springbook.biz.user.vo.UserVO;

public interface UserService {
	// CRUD 기능의 메소드 구현
	// 회원 등록
	public UserVO getUser(UserVO vo);
}
