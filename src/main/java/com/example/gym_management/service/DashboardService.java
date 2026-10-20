package com.example.gym_management.service;


import org.springframework.stereotype.Service;

import com.example.gym_management.repository.MemberRepository;
import com.example.gym_management.repository.TrainerRepository;
import com.example.gym_management.repository.MembershipRepository;
import com.example.gym_management.repository.AttendanceRepository;

@Service
public class DashboardService {

    private final MemberRepository memberRepository;
    private final TrainerRepository trainerRepository;
    private final MembershipRepository membershipRepository;
    private final AttendanceRepository attendanceRepository;

    public DashboardService(
            MemberRepository memberRepository,
            TrainerRepository trainerRepository,
            MembershipRepository membershipRepository,
            AttendanceRepository attendanceRepository) {

        this.memberRepository = memberRepository;
        this.trainerRepository = trainerRepository;
        this.membershipRepository = membershipRepository;
        this.attendanceRepository = attendanceRepository;
    }

    public long getTotalMembers() {
        return memberRepository.count();
    }

    public long getTotalTrainers() {
        return trainerRepository.count();
    }

    public long getTotalMemberships() {
        return membershipRepository.count();
    }

    public long getTotalAttendanceRecords() {
        return attendanceRepository.count();
    }
}
