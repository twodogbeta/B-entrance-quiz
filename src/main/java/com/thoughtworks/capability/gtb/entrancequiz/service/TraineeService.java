package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.domin.Trainee;
import com.thoughtworks.capability.gtb.entrancequiz.repository.InitTrainees;
import com.thoughtworks.capability.gtb.entrancequiz.repository.InitTrainees;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TraineeService {
    public List<Trainee> getTraineeList(){
        return InitTrainees.traineeList;
    }
}
