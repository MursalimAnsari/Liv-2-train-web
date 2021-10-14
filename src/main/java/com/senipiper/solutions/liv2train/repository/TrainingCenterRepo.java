package com.senipiper.solutions.liv2train.repository;


import com.senipiper.solutions.liv2train.model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingCenterRepo extends JpaRepository<TrainingCenter, Long> {

}
