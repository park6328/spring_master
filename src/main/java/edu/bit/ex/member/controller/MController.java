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

	@RequestMapping("member/list") // 회원관리스트와 게시판관리리스트가 다르므로 ....
	public String list(Model model, String msg) throws Exception {
		System.out.println("member/list호출");
		System.out.println(msg);
		
		List list = service.selectMemberList(); // service의 것을 받아온다...
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
		System.out.println("member/insertMemberPage호출");

		return "member/insertMember";
	}

	@RequestMapping(value = "member/insert", method = RequestMethod.POST)
	public String insert(MmemberVO memberVo) throws Exception {
		System.out.println("member/insertMemberPage호출");
		System.out.println(memberVo);

		// 사용자에게 받은 데이터를 저장
		service.insertMember(memberVo);

		return "redirect:/member/list";
	}
	
	// 회원삭제
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
	   