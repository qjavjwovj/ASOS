package main.java.com.kwang.openApi.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import main.java.com.kwang.openApi.vo.request.AsosDailyVo;

@RequestMapping(value = "/openApi/asos")
@Controller
public class OpenApiController {
	
	@PostMapping(value="/daily")
	public String asosDaily(@RequestBody AsosDailyVo reqVo, HttpServletRequest request, HttpServletResponse response, Model model) {
		return "";
	}
}
