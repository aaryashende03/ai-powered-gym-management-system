package com.example.gym_management.service;

import com.example.gym_management.GymManagementApplication;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gym_management.dto.MemberRequest;
import com.example.gym_management.dto.MemberResponse;
import com.example.gym_management.entity.Member;
import com.example.gym_management.repository.MemberRepository;

@Service
public class MemberService
{


	 private final MemberRepository memberRepository;

	    public MemberService(MemberRepository memberRepository) {
	        this.memberRepository = memberRepository;
	    }

	    // Convert Member entity to MemberResponse
	    private MemberResponse convertToResponse(Member member) {

	        return new MemberResponse(
	                member.getId(),
	                member.getName(),
	                member.getEmail(),
	                member.getPhone(),
	                member.getAge(),
	                member.getGender(),
	                member.getJoiningDate(),
	                member.getStatus()
	        );
	    }

	    // Get all members
	 
	    public List<MemberResponse> getAllMembers() {

	        return memberRepository.findAll()
	                .stream()
	                .map(this::convertToResponse)
	                .toList();
	    }

	    // Get member by ID
	  
	    public MemberResponse getMemberById(Long id) {

	        Member member = memberRepository.findById(id)
	                .orElseThrow(() ->
	                        new RuntimeException(
	                                "Member not found with ID: " + id));

	        return convertToResponse(member);
	    }

	    // Save member
	    public MemberResponse saveMember(MemberRequest request) {

	        Member member = new Member();

	        member.setName(request.getName());
	        member.setEmail(request.getEmail());
	        member.setPhone(request.getPhone());
	        member.setAge(request.getAge());
	        member.setGender(request.getGender());
	        member.setJoiningDate(request.getJoiningDate());
	        member.setStatus(request.getStatus());

	        Member savedMember = memberRepository.save(member);

	        return convertToResponse(savedMember);
	    }

	    // Update member
	    public MemberResponse updateMember(
	            Long id, MemberRequest request) {

	        Member member = memberRepository.findById(id)
	                .orElseThrow(() ->
	                        new RuntimeException(
	                                "Member not found with ID: " + id));

	        member.setName(request.getName());
	        member.setEmail(request.getEmail());
	        member.setPhone(request.getPhone());
	        member.setAge(request.getAge());
	        member.setGender(request.getGender());
	        member.setJoiningDate(request.getJoiningDate());
	        member.setStatus(request.getStatus());

	        Member updatedMember = memberRepository.save(member);

	        return convertToResponse(updatedMember);
	    }

	    // Delete member
	    public void deleteMember(Long id) {

	        Member member = memberRepository.findById(id)
	                .orElseThrow(() ->
	                        new RuntimeException(
	                                "Member not found with ID: " + id));

	        memberRepository.delete(member);
	    }
	}


   


