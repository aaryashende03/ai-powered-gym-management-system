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

import com.example.gym_management.dto.AttendanceRequest;
import com.example.gym_management.dto.AttendanceResponse;
import com.example.gym_management.service.AttendanceService;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
	
	
	private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    // Get all attendance records
    @GetMapping
    public List<AttendanceResponse> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }

    // Get attendance by ID
    @GetMapping("/{id}")
    public AttendanceResponse getAttendanceById(
            @PathVariable("id") Long id) {
        return attendanceService.getAttendanceById(id);
    }

    // Save attendance
    @PostMapping
    public AttendanceResponse saveAttendance(
            @RequestBody AttendanceRequest request) {
        return attendanceService.saveAttendance(request);
    }

    // Update attendance
    @PutMapping("/{id}")
    public AttendanceResponse updateAttendance(
            @PathVariable("id") Long id,
            @RequestBody AttendanceRequest request) {
        return attendanceService.updateAttendance(id, request);
    }

    // Delete attendance
    @DeleteMapping("/{id}")
    public String deleteAttendance(@PathVariable("id") Long id) {
        attendanceService.deleteAttendance(id);
        return "Attendance deleted successfully";
    }
}


