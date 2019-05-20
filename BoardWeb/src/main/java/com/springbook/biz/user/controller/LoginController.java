package com.springbook.biz.user.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.dao.UserDAO;
import com.springbook.biz.user.service.UserService;
import com.springbook.biz.user.vo.UserVO;

@Controller
public class LoginController {
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginView(@ModelAttribute("user") UserVO vo) {
		logger.debug("로그인 화면으로 이동...");
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		
		if (vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다.");
		}
		
		// UserVO user = userDAO.getUser(vo);
		UserVO user = userService.getUser(vo);
		System.out.println("여기 찍히나??");
		logger.debug("#@ login.go post res :" + user);
		logger.info("#@ login.go post res :" + user);
		
		if (user != null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		} else
			return "login.jsp";
	}
}
