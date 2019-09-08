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

	public List selectMemberList() { // List, Map, Set �÷��������� ��ũ
		List list = mapper.selectMemberList();
		return list;

	}

	public MmemberVO selectMemberOne(String id) { // �Ѹ� �޾ƿ´�......

		return mapper.selectMemberOne(id);
	}

	// ȸ����� ����
	public void insertMember(MmemberVO memberVo) {
		// ���̵� �ߺ�...*���߾� �����
		// �������
		mapper.insertMember(memberVo);
	}

	public String updateMember(MmemberVO memberVo) {

		// ��ü�� ����

		// success : ������ �ο��� ������ ��ȯ
		// ������ 1�̵Ǿ�� �Ѵ�. �׷��� ������ ����
		int success = mapper.updateMember(memberVo);

		if (success == 1) {// ���������� �����Ȱ��
			return "update success";
		} else {
			return "update error";
		}
	}

	public String deleteMember(String id) {

		// ��ü�� ����

		// success : ������ �ο��� ������ ��ȯ
		// ������ 1�̵Ǿ�� �Ѵ�. �׷��� ������ ����
		int success = mapper.deleteMember(id);
		
		
		
		if(success == 1) {// ���������� �����Ȱ��
			return "delete success";
		} else {
			return "delete error";
		}
		
		
	}

}
