package com.example.gym_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gym_management.dto.AttendanceRequest;
import com.example.gym_management.dto.AttendanceResponse;
import com.example.gym_management.entity.Attendance;
import com.example.gym_management.entity.Member;
import com.example.gym_management.entity.Trainer;
import com.example.gym_management.repository.AttendanceRepository;
import com.example.gym_management.repository.MemberRepository;
import com.example.gym_management.repository.TrainerRepository;

@Service
public class AttendanceService {
	
	  private final AttendanceRepository attendanceRepository;
	    private final MemberRepository memberRepository;
	    private final TrainerRepository trainerRepository;

	    public AttendanceService(
	            AttendanceRepository attendanceRepository,
	            MemberRepository memberRepository,
	            TrainerRepository trainerRepository) {

	        this.attendanceRepository = attendanceRepository;
	        this.memberRepository = memberRepository;
	        this.trainerRepository = trainerRepository;
	    }

	    // Convert Attendance entity into AttendanceResponse
	    private AttendanceResponse convertToResponse(Attendance attendance) {

	        return new AttendanceResponse(
	                attendance.getId(),
	                attendance.getMember().getId(),
	                attendance.getMember().getName(),
	                attendance.getTrainer() != null
	                        ? attendance.getTrainer().getId()
	                        : null,
	                attendance.getTrainer() != null
	                        ? attendance.getTrainer().getName()
	                        : null,
	                attendance.getDate(),
	                attendance.getStatus()
	        );
	    }

	    // Get all attendance records
	  
	    public List<AttendanceResponse> getAllAttendance() {

	        return attendanceRepository.findAll()
	                .stream()
	                .map(this::convertToResponse)
	                .toList();
	    }

	    // Get attendance by ID
	 
	    public AttendanceResponse getAttendanceById(Long id) {

	        Attendance attendance = attendanceRepository.findById(id)
	                .orElseThrow(() ->
	                        new RuntimeException(
	                                "Attendance not found with ID: " + id));

	        return convertToResponse(attendance);
	    }

	    // Save attendance
	    public AttendanceResponse saveAttendance(AttendanceRequest request) {

	        Member member = memberRepository.findById(request.getMemberId())
	                .orElseThrow(() ->
	                        new RuntimeException(
	                                "Member not found with ID: "
	                                        + request.getMemberId()));

	        Attendance attendance = new Attendance();
	        attendance.setMember(member);

	        // Trainer is optional
	        if (request.getTrainerId() != null) {

	            Trainer trainer = trainerRepository
	                    .findById(request.getTrainerId())
	                    .orElseThrow(() ->
	                            new RuntimeException(
	                                    "Trainer not found with ID: "
	                                            + request.getTrainerId()));

	            attendance.setTrainer(trainer);
	        } else {
	            attendance.setTrainer(null);
	        }

	        attendance.setDate(request.getDate());
	        attendance.setStatus(request.getStatus());

	        Attendance savedAttendance =
	                attendanceRepository.save(attendance);

	        return convertToResponse(savedAttendance);
	    }

	    // Update attendance
	    public AttendanceResponse updateAttendance(
	            Long id, AttendanceRequest request) {

	        Attendance attendance = attendanceRepository.findById(id)
	                .orElseThrow(() ->
	                        new RuntimeException(
	                                "Attendance not found with ID: " + id));

	        Member member = memberRepository.findById(request.getMemberId())
	                .orElseThrow(() ->
	                        new RuntimeException(
	                                "Member not found with ID: "
	                                        + request.getMemberId()));

	        attendance.setMember(member);

	        if (request.getTrainerId() != null) {

	            Trainer trainer = trainerRepository
	                    .findById(request.getTrainerId())
	                    .orElseThrow(() ->
	                            new RuntimeException(
	                                    "Trainer not found with ID: "
	                                            + request.getTrainerId()));

	            attendance.setTrainer(trainer);
	        } else {
	            attendance.setTrainer(null);
	        }

	        attendance.setDate(request.getDate());
	        attendance.setStatus(request.getStatus());

	        Attendance updatedAttendance =
	                attendanceRepository.save(attendance);

	        return convertToResponse(updatedAttendance);
	    }

	    // Delete attendance
	    public void deleteAttendance(Long id) {

	        Attendance attendance = attendanceRepository.findById(id)
	                .orElseThrow(() ->
	                        new RuntimeException(
	                                "Attendance not found with ID: " + id));

	        attendanceRepository.delete(attendance);
	    }
	}


