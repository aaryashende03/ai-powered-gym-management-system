package com.example.gym_management.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gym_management.dto.MemberRequest;
import com.example.gym_management.dto.MemberResponse;
import com.example.gym_management.service.MemberService;

@RestController

@RequestMapping("/members")
public class MemberController {
	
	 private final MemberService memberService;

	    public MemberController(MemberService memberService) {
	        this.memberService = memberService;
	    }

	    // Get all members
	    @GetMapping
	    public List<MemberResponse> getAllMembers() {
	        return memberService.getAllMembers();
	    }

	    // Get member by ID
	    @GetMapping("/{id}")
	    public MemberResponse getMemberById(
	            @PathVariable("id") Long id) {
	        return memberService.getMemberById(id);
	    }

	    // Add a new member
	    @PostMapping
	    public MemberResponse saveMember(
	            @RequestBody MemberRequest request) {
	        return memberService.saveMember(request);
	    }

	    // Update an existing member
	    @PutMapping("/{id}")
	    public MemberResponse updateMember(
	            @PathVariable("id") Long id,
	            @RequestBody MemberRequest request) {
	        return memberService.updateMember(id, request);
	    }

	    // Delete a member
	    @DeleteMapping("/{id}")
	    public String deleteMember(@PathVariable("id") Long id) {
	        memberService.deleteMember(id);
	        return "Member deleted successfully";
	    }
	}