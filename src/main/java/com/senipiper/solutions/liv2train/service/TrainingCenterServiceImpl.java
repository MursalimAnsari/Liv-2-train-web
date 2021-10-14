package com.senipiper.solutions.liv2train.service;

import com.senipiper.solutions.liv2train.exception.DBOperationException;
import com.senipiper.solutions.liv2train.model.TrainingCenter;
import com.senipiper.solutions.liv2train.repository.TrainingCenterRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TrainingCenterServiceImpl implements TrainingCenterService {

    @Autowired
    TrainingCenterRepo trainingCenterRepo;

    @Override
    public TrainingCenter addNewTrainingCenter(TrainingCenter trainingCenter) {
        try {
            log.info("Adding new record {}", trainingCenter);
            return trainingCenterRepo.save(trainingCenter);
        } catch (Exception e) {
            throw new DBOperationException("Could not add new training center in DB");
        }
    }

    @Override
    public List<TrainingCenter> getAllCenters() {
        try {
            log.info("Get all records");
            return trainingCenterRepo.findAll();
        } catch (Exception e) {
            throw new DBOperationException("Could not fetch record from DB");
        }
    }
}
