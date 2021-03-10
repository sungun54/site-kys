package com.my.site.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.my.site.dto.ResultData;
import com.my.site.service.MemberService;
import com.my.site.util.Util;

@Controller
public class MemberController {	
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/usr/member/login")
	public String showMemberLogin() {
		return "member/login";
	}	
	
	@RequestMapping("/usr/member/join")
	public String showMemberJoin() {
		return "member/join";
	}	
	
	@RequestMapping("/usr/member/doJoin")
	public String showMemberDoJoin(@RequestParam Map<String, Object> param, Model model) {
		ResultData checkLoginIdJoinableResultData = memberService
				.checkLoginIdJoinable(Util.getAsStr(param.get("loginId")));

		if (checkLoginIdJoinableResultData.isFail()) {
			model.addAttribute("historyBack", true);
			model.addAttribute("alertMsg", checkLoginIdJoinableResultData.getMsg());
			return "common/redirect";
		}

		ResultData checkNicknameJoinableResultData = memberService
				.checkNicknameJoinable(Util.getAsStr(param.get("nickname")));

		if (checkNicknameJoinableResultData.isFail()) {
			model.addAttribute("historyBack", true);
			model.addAttribute("alertMsg", checkNicknameJoinableResultData.getMsg());
			return "common/redirect";
		}

		ResultData checkEmailJoinableResultData = memberService.checkEmailJoinable(Util.getAsStr(param.get("email")));

		if (checkEmailJoinableResultData.isFail()) {
			model.addAttribute("historyBack", true);
			model.addAttribute("alertMsg", checkEmailJoinableResultData.getMsg());
			return "common/redirect";
		}

		int id = memberService.join(param);

		return "member/login";
	}	
	
}
