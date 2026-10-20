package com.example.gym_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gym_management.entity.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer,Long> {
	
	

}
