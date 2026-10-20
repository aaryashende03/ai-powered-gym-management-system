package com.example.gym_management.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gym_management.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
	
	Optional<Member> findById(Long id);
	
	
	

	


}
