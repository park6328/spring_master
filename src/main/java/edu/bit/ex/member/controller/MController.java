package edu.bit.ex.member.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.bit.ex.member.service.Mservice;
import edu.bit.ex.member.vo.MmemberVO;

@Controller
public class MController {

	@Inject
	Mservice service;

	@RequestMapping("member/list") // ȸ��������Ʈ�� �Խ��ǰ�������Ʈ�� �ٸ��Ƿ� ....
	public String list(Model model, String msg) throws Exception {
		System.out.println("member/listȣ��");
		System.out.println(msg);
		
		List list = service.selectMemberList(); // service�� ���� �޾ƿ´�...
		model.addAttribute("memberList", list);
		model.addAttribute("msg", msg);

		return "member/list";
	}

	@RequestMapping("member/content_view")
	public String content_view(Model model, HttpServletRequest request) throws Exception {
		System.out.println("content_view()");

		String id = request.getParameter("id");

		model.addAttribute("content_view", service.selectMemberOne(id));

		return "member/content_view";
	}

	@RequestMapping("member/insertMember")
	public String insertMemberPage() throws Exception {
		System.out.println("member/insertMemberPageȣ��");

		return "member/insertMember";
	}

	@RequestMapping(value = "member/insert", method = RequestMethod.POST)
	public String insert(MmemberVO memberVo) throws Exception {
		System.out.println("member/insertMemberPageȣ��");
		System.out.println(memberVo);

		// ����ڿ��� ���� �����͸� ����
		service.insertMember(memberVo);

		return "redirect:/member/list";
	}
	
	// ȸ������
	@RequestMapping("member/delete")
	public String delete(Model model, HttpServletRequest request) throws Exception {
		// http://localhost:8282/member/delete?id=1234
		String id = request.getParameter("id");	// 1234
		
		System.out.println("safsafas");
		System.out.println("id="+id);
		
		String msg = service.deleteMember(id);
		
		model.addAttribute("msg", msg);
				
		return "redirect:/member/list";
	}

	
	@RequestMapping("member/update")
	public String update(MmemberVO memberVo) throws Exception {

		System.out.println(memberVo);
			
		String msg = service.updateMember(memberVo);
		
		return "redirect:/member/list?msg="+ msg;
	}
	
	
}
	   