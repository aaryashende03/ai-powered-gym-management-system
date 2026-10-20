package com.example.gym_management.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.gym_management.dto.AttendanceResponse;
import com.example.gym_management.dto.MemberResponse;
import com.example.gym_management.service.AttendanceService;
import com.example.gym_management.service.DashboardService;
import com.example.gym_management.service.MemberService;

@Controller
public class DashboardController {

    private final DashboardService dashboardService;
    private final AttendanceService attendanceService;
    private final MemberService memberservice;
    

    public DashboardController(DashboardService dashboardService, AttendanceService attendanceService,MemberService memberService) {
        this.dashboardService = dashboardService;
        this.attendanceService=attendanceService;
        this.memberservice=memberService;
    }

    @GetMapping({"/", "/dashboard"})
    public String showDashboard(Model model) {

        model.addAttribute(
                "totalMembers",
                dashboardService.getTotalMembers());

        model.addAttribute(
                "totalTrainers",
                dashboardService.getTotalTrainers());

        model.addAttribute(
                "totalMemberships",
                dashboardService.getTotalMemberships());

        model.addAttribute(
                "totalAttendance",
                dashboardService.getTotalAttendanceRecords());
        
        List<AttendanceResponse> attendanceList =
                attendanceService.getAllAttendance();

        model.addAttribute("attendanceList", attendanceList);
        
        // Members list
      
        return "dashboard";
        
        
    }
    
 
}

    

