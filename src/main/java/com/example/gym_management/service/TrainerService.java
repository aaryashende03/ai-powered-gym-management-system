 package com.example.gym_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gym_management.dto.TrainerRequest;
import com.example.gym_management.dto.TrainerResponse;
import com.example.gym_management.entity.Trainer;
import com.example.gym_management.repository.TrainerRepository;

@Service
public class TrainerService {
	
	private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    // Convert entity to response DTO
    private TrainerResponse convertToResponse(Trainer trainer) {
        return new TrainerResponse(
                trainer.getId(),
                trainer.getName(),
                trainer.getEmail(),
                trainer.getPhone(),
                trainer.getSpecialization(),
                trainer.getExperience(),
                trainer.getJoiningDate(),
                trainer.getStatus()
        );
    }

    // Get all trainers
   
    public List<TrainerResponse> getAllTrainers() {
        return trainerRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .toList();
    }

    // Get trainer by ID
       public TrainerResponse getTrainerById(Long id) {
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Trainer not found with ID: " + id));

        return convertToResponse(trainer);
    }

    // Create trainer
  
    public TrainerResponse saveTrainer(TrainerRequest request) {
        Trainer trainer = new Trainer();

        trainer.setName(request.getName());
        trainer.setEmail(request.getEmail());
        trainer.setPhone(request.getPhone());
        trainer.setSpecialization(request.getSpecialization());
        trainer.setExperience(request.getExperience());
        trainer.setJoiningDate(request.getJoiningDate());
        trainer.setStatus(request.getStatus());

        Trainer savedTrainer = trainerRepository.save(trainer);

        return convertToResponse(savedTrainer);
    }

    // Update trainer
   
    public TrainerResponse updateTrainer(Long id, TrainerRequest request) {
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Trainer not found with ID: " + id));

        trainer.setName(request.getName());
        trainer.setEmail(request.getEmail());
        trainer.setPhone(request.getPhone());
        trainer.setSpecialization(request.getSpecialization());
        trainer.setExperience(request.getExperience());
        trainer.setJoiningDate(request.getJoiningDate());
        trainer.setStatus(request.getStatus());

        Trainer updatedTrainer = trainerRepository.save(trainer);

        return convertToResponse(updatedTrainer);
    }

    // Delete trainer
  
    public String deleteTrainer(Long id) {
        Trainer trainer = trainerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Trainer not found with ID: " + id));

        trainerRepository.delete(trainer);

        return "Trainer deleted successfully";
    }
}


