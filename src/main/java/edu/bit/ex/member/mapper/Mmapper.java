package edu.bit.ex.member.mapper;

import java.lang.reflect.Member;
import java.util.List;

import edu.bit.ex.member.vo.MmemberVO;

public interface Mmapper {

	public List<MmemberVO> selectMemberList();
	
	public MmemberVO selectMemberOne(String id);
	
	public void insertMember(MmemberVO vo);

	public void delectMember(MmemberVO memberVo);

	public int updateMember(MmemberVO memberVo);

	public int deleteMember(String id);

	
	
	
	
}
