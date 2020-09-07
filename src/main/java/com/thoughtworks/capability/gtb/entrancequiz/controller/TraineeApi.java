package com.thoughtworks.capability.gtb.entrancequiz.controller;

import com.thoughtworks.capability.gtb.entrancequiz.domin.Trainee;
import com.thoughtworks.capability.gtb.entrancequiz.service.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TraineeApi {
        TraineeService traineeService;
        @ResponseStatus(HttpStatus.OK)
        public List<Trainee> getTraineeList() {
            return traineeService.getTraineeList();
        }
}
