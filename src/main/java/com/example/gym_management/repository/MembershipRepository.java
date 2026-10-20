package com.example.gym_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gym_management.entity.Membership;

@Repository
public interface MembershipRepository extends JpaRepository<Membership,Long> {
	
	List<Membership> findByMember_Id(Long memberId);
}
