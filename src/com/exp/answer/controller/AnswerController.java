package com.exp.answer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.exp.answer.service.AnswerServiceImpl;
import com.exp.entity.Answer;
import com.framework.Page;

@Controller
@RequestMapping("/answer")
public class AnswerController {
	@Resource
	private AnswerServiceImpl answerserviceimpl;

	/**
	 * @author Ray_1 按时间顺序分页查询个人所提问题的问题
	 * @param pageNum
	 *            一页有多少
	 * @param request
	 * @return
	 */
	@RequestMapping("/findAnswerByTime")
	public String list(@RequestParam(name = "pageNum", defaultValue = "1") int pageNum, HttpServletRequest request) {
		Page<Answer> pages;
		int userinfoId = 1;
		pages = this.answerserviceimpl.findAnswerByTime(pageNum, 6, new Object[] { userinfoId });
		request.setAttribute("pages", pages);
		return "home-answer";
	}
}