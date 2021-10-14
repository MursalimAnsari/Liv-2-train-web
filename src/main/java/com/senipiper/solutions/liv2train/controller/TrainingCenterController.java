package com.senipiper.solutions.liv2train.controller;


import com.senipiper.solutions.liv2train.exception.DBOperationException;
import com.senipiper.solutions.liv2train.exception.ServerTypeException;
import com.senipiper.solutions.liv2train.exception.UserTypeException;
import com.senipiper.solutions.liv2train.model.TrainingCenter;
import com.senipiper.solutions.liv2train.service.TrainingCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class TrainingCenterController {

    @Autowired
    private TrainingCenterService trainingCenterService;

    @PostMapping
    @RequestMapping("/add-center")
    public TrainingCenter addNewTrainingCenter(@RequestBody TrainingCenter trainingCenter){

        try {
            return  trainingCenterService.addNewTrainingCenter(trainingCenter);
        }catch (DBOperationException e){
            throw new UserTypeException("Request could not proceed", Collections.emptyList());
        }
    }

    @GetMapping
    @RequestMapping("/centers")
    public List<TrainingCenter>  getAllCenters(){
        try {
            return trainingCenterService.getAllCenters();
        }catch (DBOperationException e){
            throw new UserTypeException("Request could not proceed", Collections.emptyList());
        }
    }


}
