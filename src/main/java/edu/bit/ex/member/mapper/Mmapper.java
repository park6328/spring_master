package edu.bit.ex.member.mapper;

import java.util.List;

import edu.bit.ex.member.vo.MemberVO;

public interface Mmapper {

	public List selectMemberList();
	
	public void insertMember(MemberVO vo);

	public void delectMember(String id);
	
	
	
}
