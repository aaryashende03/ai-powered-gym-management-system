
package com.example.gym_management.chatbot;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gym_management.entity.Membership;
import com.example.gym_management.entity.Attendance;
import com.example.gym_management.entity.Trainer;

import com.example.gym_management.repository.MembershipRepository;
import com.example.gym_management.repository.AttendanceRepository;
import com.example.gym_management.repository.TrainerRepository;

@Service
public class ChatbotService {

    private final MembershipRepository membershipRepository;
    private final AttendanceRepository attendanceRepository;
    private final TrainerRepository trainerRepository;

    public ChatbotService(
            MembershipRepository membershipRepository,
            AttendanceRepository attendanceRepository,
            TrainerRepository trainerRepository) {

        this.membershipRepository = membershipRepository;
        this.attendanceRepository = attendanceRepository;
        this.trainerRepository = trainerRepository;
    }

    public String getResponse(String message) {

        if (message == null || message.trim().isEmpty()) {
            return "Please enter a question.";
        }

        String question = message.toLowerCase().trim();

        // Greeting
        if (question.equals("hello")
                || question.equals("hi")
                || question.startsWith("hello ")) {
            return "Hello! Welcome to our Gym Management System. How can I help you?";
        }

        // Membership details
        if (question.contains("membership type for member")) {
            return getMembershipDetails(question, "type");
        }

        if (question.contains("membership expiry for member")
                || question.contains("membership expire for member")) {
            return getMembershipDetails(question, "expiry");
        }

        if (question.contains("membership status for member")) {
            return getMembershipDetails(question, "status");
        }

        // Attendance count
        if (question.contains("attendance count for member")
                || question.contains("how many times has member")) {
            return getAttendanceDetails(question, "count");
        }

        // Attendance history
        if (question.contains("attendance history for member")
                || question.contains("show attendance for member")
                || question.contains("attendance for member")) {
            return getAttendanceDetails(question, "history");
        }

        // Show all trainers
        if (question.contains("show all trainers")
                || question.contains("list all trainers")) {
            return getAllTrainers();
        }

        // Trainer count
        if (question.contains("how many trainers")
                || question.contains("trainer count")) {
            return "Total trainers: " + trainerRepository.count();
        }

        // Trainer details
        if (question.contains("trainer")) {

            Long trainerId = extractTrainerId(question);

            if (trainerId != null) {
                return getTrainerDetails(trainerId, question);
            }

            return "Try asking: show all trainers or find trainer 1.";
        }

        // Personal training FAQ
        if (question.contains("personal training")) {
            return "Our system manages trainer information. Ask me to show all trainers.";
        }

        // General membership FAQ
        if (question.contains("membership")) {
            return "We offer gym membership options. Please contact the gym for available plans and prices.";
        }

        // Gym timings
        if (question.contains("timing")
                || question.contains("opening hours")) {
            return "Please contact the gym to confirm its opening and closing hours.";
        }

        // General attendance FAQ
        if (question.contains("attendance")) {
            return "Try asking: show attendance for member 1";
        }

        // Thanks
        if (question.contains("thank")) {
            return "You're welcome! Let me know if you have another gym-related question.";
        }

        // Goodbye
        if (question.equals("bye")) {
            return "Goodbye! Have a great workout.";
        }

        return "Sorry, I don't know the answer to that question yet. Ask me about memberships, attendance, trainers, or gym timings.";
    }

    // ================= MEMBERSHIP DETAILS =================

    private String getMembershipDetails(
            String question, String detail) {

        Long memberId = extractMemberId(question);

        if (memberId == null) {
            return "Please enter a valid member ID, for example: membership type for member 1";
        }

        List<Membership> memberships =
                membershipRepository.findByMember_Id(memberId);

        if (memberships.isEmpty()) {
            return "No membership found for member ID "
                    + memberId + ".";
        }

        Membership membership = memberships.get(0);

        switch (detail) {

            case "type":
                return "Membership type: "
                        + membership.getMembershipType();

            case "expiry":
                return "Membership expiry date: "
                        + membership.getEndDate();

            case "status":
                return "Membership status: "
                        + membership.getStatus();

            default:
                return "Sorry, I couldn't find that membership detail.";
        }
    }

    // ================= ATTENDANCE DETAILS =================

    private String getAttendanceDetails(
            String question, String detail) {

        Long memberId = extractMemberId(question);

        if (memberId == null) {
            return "Please enter a valid member ID, for example: show attendance for member 1";
        }

        List<Attendance> records =
                attendanceRepository
                        .findByMember_IdOrderByDateDesc(memberId);

        if (records.isEmpty()) {
            return "No attendance records found for member ID "
                    + memberId + ".";
        }

        if (detail.equals("count")) {
            return "Member " + memberId + " has "
                    + records.size() + " attendance record(s).";
        }

        StringBuilder result = new StringBuilder(
                "Attendance history for member "
                        + memberId + ":\n");

        for (Attendance attendance : records) {
            result.append("Date: ")
                    .append(attendance.getDate())
                    .append(", Status: ")
                    .append(attendance.getStatus())
                    .append("\n");
        }

        return result.toString();
    }

    // ================= TRAINER DETAILS =================

    private String getAllTrainers() {

        List<Trainer> trainers = trainerRepository.findAll();

        if (trainers.isEmpty()) {
            return "No trainers found.";
        }

        StringBuilder result =
                new StringBuilder("Our trainers:\n");

        for (Trainer trainer : trainers) {
            result.append("ID: ")
                    .append(trainer.getId())
                    .append(", Name: ")
                    .append(trainer.getName())
                    .append(", Specialization: ")
                    .append(trainer.getSpecialization())
                    .append("\n");
        }

        return result.toString();
    }

    private String getTrainerDetails(
            Long trainerId, String question) {

        return trainerRepository.findById(trainerId)
                .map(trainer -> {

                    if (question.contains("specialization")) {
                        return "Trainer specialization: "
                                + trainer.getSpecialization();
                    }

                    if (question.contains("experience")) {
                        return "Trainer experience: "
                                + trainer.getExperience() + " years.";
                    }

                    return "Trainer ID: " + trainer.getId()
                            + ", Name: " + trainer.getName()
                            + ", Specialization: "
                            + trainer.getSpecialization()
                            + ", Experience: "
                            + trainer.getExperience() + " years"
                            + ", Status: " + trainer.getStatus();
                })
                .orElse("No trainer found with ID "
                        + trainerId + ".");
    }

    // ================= ID EXTRACTION =================

    private Long extractMemberId(String question) {

        String[] words = question.split("\\s+");

        for (int i = 0; i < words.length - 1; i++) {

            if (words[i].equals("member")) {
                try {
                    return Long.parseLong(words[i + 1]);
                } catch (NumberFormatException e) {
                    return null;
                }
            }
        }

        return null;
    }

    private Long extractTrainerId(String question) {

        String[] words = question.split("\\s+");

        for (int i = 0; i < words.length - 1; i++) {

            if (words[i].equals("trainer")) {
                try {
                    return Long.parseLong(words[i + 1]);
                } catch (NumberFormatException e) {
                    return null;
                }
            }
        }

        return null;
    }
}
