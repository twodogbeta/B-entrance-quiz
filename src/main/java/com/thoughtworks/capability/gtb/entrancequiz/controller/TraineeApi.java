package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.thoughtworks.capability.gtb.entrancequiz.domin.Group;
import com.thoughtworks.capability.gtb.entrancequiz.domin.Trainee;
import com.thoughtworks.capability.gtb.entrancequiz.service.TraineeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TraineeApi {

    private final TraineeService traineeService;

    public TraineeApi(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    @GetMapping("/allTrainees")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public List<Trainee> getTraineeList() {

        return traineeService.getTraineeList();
    }

    @GetMapping("/allGroups")
    @CrossOrigin
    @ResponseStatus(HttpStatus.OK)
    public List<Group> getGroupList() throws JsonProcessingException {
        List<Group> groupList = traineeService.getGroupList();
        return groupList;
    }

}
