
package com.example.gym_management.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.gym_management.dto.MemberRequest;
import com.example.gym_management.dto.MembershipRequest;
import com.example.gym_management.dto.MembershipResponse;
import com.example.gym_management.entity.Member;
import com.example.gym_management.entity.Membership;
import com.example.gym_management.repository.MemberRepository;
import com.example.gym_management.repository.MembershipRepository;

@Service
public class MembershipService {

	 private final MembershipRepository membershipRepository;
	    private final MemberRepository memberRepository;

	    public MembershipService(
	            MembershipRepository membershipRepository,
	            MemberRepository memberRepository) {

	        this.membershipRepository = membershipRepository;
	        this.memberRepository = memberRepository;
	    }

	    // Convert Membership entity to MembershipResponse
	    private MembershipResponse convertToResponse(
	            Membership membership) {

	        return new MembershipResponse(
	                membership.getId(),
	                membership.getMember().getId(),
	                membership.getMember().getName(),
	                membership.getMembershipType(),
	                membership.getStartDate(),
	                membership.getEndDate(),
	                membership.getStatus()
	        );
	    }

	    // Get all memberships
	    @Transactional(readOnly = true)
	    public List<MembershipResponse> getAllMemberships() {

	        return membershipRepository.findAll()
	                .stream()
	                .map(this::convertToResponse)
	                .toList();
	    }

	    // Get membership by ID
	    @Transactional(readOnly = true)
	    public MembershipResponse getMembershipById(Long id) {

	        Membership membership = membershipRepository.findById(id)
	                .orElseThrow(() ->
	                        new RuntimeException(
	                                "Membership not found with ID: " + id));

	        return convertToResponse(membership);
	    }

	    // Save membership
	    public MembershipResponse saveMembership(
	            MembershipRequest request) {

	        Member member = memberRepository
	                .findById(request.getMemberId())
	                .orElseThrow(() ->
	                        new RuntimeException(
	                                "Member not found with ID: "
	                                        + request.getMemberId()));

	        Membership membership = new Membership();

	        membership.setMember(member);
	        membership.setMembershipType(request.getMembershipType());
	        membership.setStartDate(request.getStartDate());
	        membership.setEndDate(request.getEndDate());
	        membership.setStatus(request.getStatus());

	        Membership savedMembership =
	                membershipRepository.save(membership);

	        return convertToResponse(savedMembership);
	    }

	    // Update membership
	    public MembershipResponse updateMembership(
	            Long id, MembershipRequest request) {

	        Membership membership = membershipRepository.findById(id)
	                .orElseThrow(() ->
	                        new RuntimeException(
	                                "Membership not found with ID: " + id));

	        Member member = memberRepository
	                .findById(request.getMemberId())
	                .orElseThrow(() ->
	                        new RuntimeException(
	                                "Member not found with ID: "
	                                        + request.getMemberId()));

	        membership.setMember(member);
	        membership.setMembershipType(request.getMembershipType());
	        membership.setStartDate(request.getStartDate());
	        membership.setEndDate(request.getEndDate());
	        membership.setStatus(request.getStatus());

	        Membership updatedMembership =
	                membershipRepository.save(membership);

	        return convertToResponse(updatedMembership);
	    }

	    // Delete membership
	    public void deleteMembership(Long id) {

	        Membership membership = membershipRepository.findById(id)
	                .orElseThrow(() ->
	                        new RuntimeException(
	                                "Membership not found with ID: " + id));

	        membershipRepository.delete(membership);
	    }
	}