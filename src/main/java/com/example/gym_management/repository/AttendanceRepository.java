package com.example.gym_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gym_management.entity.Attendance;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance,Long>{

	List<Attendance> findByMember_IdOrderByDateDesc(Long memberId);
}
