package edu.bit.ex.member.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import edu.bit.ex.member.mapper.Mmapper;
import edu.bit.ex.member.vo.MemberVO;

@Service
public class Mservice {
	
	@Inject
	Mmapper mapper;// Mapper = new member.xml();
	
	public List selectMemberList() {
		List list = mapper.selectMemberList();
		return list;
		
	}

	//회원등록 서비스
	public void insertMember(MemberVO memberVo) {
		//아이디 중복...*나중애 만들어		
		// 저장수행
		mapper.insertMember(memberVo);		
	}	
	
}
