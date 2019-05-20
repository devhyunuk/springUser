package com.springbook.biz.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.board.vo.BoardVO;
import com.springbook.biz.user.vo.UserVO;

@Repository
public class BoardDAOMybatis{
	
	@Autowired
	private SqlSessionTemplate mybatis;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	public void insertBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 insertBoard() 기능 처리");
		mybatis.insert("BoardDAO.insertBoard", vo);
		System.out.println("Res insertBoard seq :" + vo.getSeq());
		
		// #@ TEST redis
		// Redis에 사용자 정보를 등록한다.
		String key = String.valueOf(vo.getSeq());
		System.out.println("redis put key :" + key);
		Map<String, Object> mapBoardVo = new HashMap<>();
		mapBoardVo.put("seq", vo.getSeq());
		mapBoardVo.put("title", vo.getTitle());
		mapBoardVo.put("writer", vo.getWriter());
		mapBoardVo.put("content", vo.getContent());
		redisTemplate.opsForHash().putAll(key, mapBoardVo);
		
		System.out.println("redis boardVo :" + mapBoardVo);
	}

	public void updateBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 updateBoard() 기능 처리");
		mybatis.update("BoardDAO.updateBoard", vo);
	}

	public void deleteBoard(BoardVO vo) {
		System.out.println("===> Mybatis로 deleteBoard() 기능 처리");
		mybatis.delete("BoardDAO.deleteBoard", vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		
		try {
			String key = String.valueOf(vo.getSeq());
			System.out.println("redis getBoard key :" + key);
	        System.out.println("redis get seq :" + redisTemplate.opsForHash().get(key, "seq").toString());
	        System.out.println("redis get title :" + redisTemplate.opsForHash().get(key, "title").toString());
	        System.out.println("redis get writer :" + redisTemplate.opsForHash().get(key, "writer").toString());
	        System.out.println("redis get content :" + redisTemplate.opsForHash().get(key, "content").toString());	
		} catch(Exception e) {
			System.out.println("Exception e :" + e);
		}
		
		
		System.out.println("===> Mybatis로 getBoard() 기능 처리 mybatis :" + mybatis);
		return (BoardVO) mybatis.selectOne("BoardDAO.getBoard", vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===> Mybatis로 getBoardList() 기능 처리 mybatis :" + mybatis);
		
		UserVO res = null;
		UserVO req = new UserVO();
		req.setId("test");
		req.setPassword("test123");
		try {
			res = (UserVO) mybatis.selectOne("UserDAO.getUser", req);
		} catch (Exception e) {
			System.out.println("#@ Exception e :" + e);
		}
		System.out.println("#@ User res :" + res);
		
		return mybatis.selectList("BoardDAO.getBoardList", vo);
	}
}