package edu.bit.ex.member.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import edu.bit.ex.member.mapper.Mmapper;
import edu.bit.ex.member.vo.MmemberVO;

@Service
public class Mservice {

	@Inject
	Mmapper mapper;// Mapper = new member.xml();

	public List selectMemberList() { // List, Map, Set 컬렉션프레임 워크
		List list = mapper.selectMemberList();
		return list;

	}

	public MmemberVO selectMemberOne(String id) { // 한명만 받아온다......

		return mapper.selectMemberOne(id);
	}

	// 회원등록 서비스
	public void insertMember(MmemberVO memberVo) {
		// 아이디 중복...*나중애 만들어
		// 저장수행
		mapper.insertMember(memberVo);
	}

	public String updateMember(MmemberVO memberVo) {

		// 객체로 묶어

		// success : 수정한 로우의 개수를 반환
		// 무조건 1이되어야 한다. 그렇지 않으면 오류
		int success = mapper.updateMember(memberVo);

		if (success == 1) {// 정상적으로 수정된경우
			return "update success";
		} else {
			return "update error";
		}
	}

	public String deleteMember(String id) {

		// 객체로 묶어

		// success : 수정한 로우의 개수를 반환
		// 무조건 1이되어야 한다. 그렇지 않으면 오류
		int success = mapper.deleteMember(id);
		
		
		
		if(success == 1) {// 정상적으로 수정된경우
			return "delete success";
		} else {
			return "delete error";
		}
		
		
	}

}
