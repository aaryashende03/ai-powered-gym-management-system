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

import com.example.gym_management.dto.TrainerRequest;
import com.example.gym_management.dto.TrainerResponse;
import com.example.gym_management.service.TrainerService;

@RestController
@RequestMapping("/trainers")
public class TrainerController {
	
	 private final TrainerService trainerService;

	    public TrainerController(TrainerService trainerService) {
	        this.trainerService = trainerService;
	    }

	    // Get all trainers
	    @GetMapping
	    public List<TrainerResponse> getAllTrainers() {
	        return trainerService.getAllTrainers();
	    }

	    // Get trainer by ID
	    @GetMapping("/{id}")
	    public TrainerResponse getTrainerById(
	            @PathVariable("id") Long id) {
	        return trainerService.getTrainerById(id);
	    }

	    // Create trainer
	    @PostMapping
	    public TrainerResponse saveTrainer(
	            @RequestBody TrainerRequest request) {
	        return trainerService.saveTrainer(request);
	    }

	    // Update trainer
	    @PutMapping("/{id}")
	    public TrainerResponse updateTrainer(
	            @PathVariable("id") Long id,
	            @RequestBody TrainerRequest request) {
	        return trainerService.updateTrainer(id, request);
	    }

	    // Delete trainer
	    @DeleteMapping("/{id}")
	    public String deleteTrainer(@PathVariable("id") Long id) {
	        return trainerService.deleteTrainer(id);
	    }
	}


