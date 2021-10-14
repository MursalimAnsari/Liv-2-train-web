package com.senipiper.solutions.liv2train.service;

import com.senipiper.solutions.liv2train.model.TrainingCenter;

import java.util.List;


public interface TrainingCenterService {

    public TrainingCenter addNewTrainingCenter(TrainingCenter trainingCenter);

    public  List<TrainingCenter> getAllCenters();
}
