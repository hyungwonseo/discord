package com.dw.discord.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dw.discord.dto.BaseResponse;
import com.dw.discord.dto.MemberDto;
import com.dw.discord.dto.MemberLoginDto;
import com.dw.discord.service.impl.MemberServiceImpl;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins="http://localhost:3000",
		methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class MemberController {
	
	private final MemberServiceImpl memberServiceImpl;
	
	@Autowired	
	public MemberController(MemberServiceImpl memberServiceImpl) {
		super();
		this.memberServiceImpl = memberServiceImpl;
	}

	@PostMapping("/api/signup")
	public ResponseEntity<BaseResponse<Void>> signUp(@RequestBody @Valid MemberDto memberDto) {
		return new ResponseEntity<BaseResponse<Void>>(
					memberServiceImpl.signUp(memberDto),					
					HttpStatus.CREATED);
	}
	
	@PostMapping("/api/login")
	public ResponseEntity<BaseResponse<Void>> login(@RequestBody @Valid MemberLoginDto memberLoginDto) {
		return new ResponseEntity<BaseResponse<Void>>(
					memberServiceImpl.login(memberLoginDto),
					HttpStatus.OK);
	}
}















