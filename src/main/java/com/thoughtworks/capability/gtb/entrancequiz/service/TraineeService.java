package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capability.gtb.entrancequiz.domin.Group;
import com.thoughtworks.capability.gtb.entrancequiz.domin.Trainee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TraineeService {
    private static List<Trainee> traineeList =  new ArrayList<>();;
    private  int initId = 1;
    private List<String> initTraineeList = Arrays.asList(
            "沈乐棋", "徐慧慧" , "陈思聪" , "王江林", "王登宇","杨思雨","江雨舟",
                    "廖燊", "胡晓","但杰", "盖迈达", "肖美琪" , "黄云洁" ,
                    "齐瑾浩", "刘亮亮","肖逸凡","王作文","郭瑞凌", "李明豪","党泽",
                    "肖伊佐","贠晨曦","李康宁","马庆" ,"商婕","余榕","谌哲",
                    "董翔锐","陈泰宇","赵允齐","张柯" ,"廖文强",
                    "刘柯","廖浚斌","凌凤仪");
    private Trainee addNewTrainee(String name) {
        return Trainee.builder()
                .id(initId++)
                .name(name)
                .build();
    }
    public TraineeService() {
        initTraineeList();
    }
    private void initTraineeList() {
        traineeList.clear();
        for (int i = 0; i < initTraineeList.size(); i++)
            traineeList.add(addNewTrainee(initTraineeList.get(i)));
    }

    public  List<Trainee> getTraineeList() {
        return traineeList;
    }



    TraineeService traineeService;
    private int groupCount = 6;

    public  List<Trainee> deepCopy() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(traineeList);
        JavaType jt = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, Trainee.class);
        return objectMapper.readValue(jsonString, jt);
    }
    public void swapTrainee(List<Trainee> tL, int indexA, int indexB) {
        Trainee TraineeA = tL.get(indexA);
        Trainee TraineeB = tL.get(indexB);
        Trainee tempA = new Trainee(TraineeA.getId(), TraineeA.getName());

        tL.set(indexA, TraineeB);
        tL.set(indexB, tempA);
    }
    public List<Trainee> shuffleList() throws JsonProcessingException {
        List<Trainee> toShuffle = deepCopy();

        int size = traineeList.size();

        Random random = new Random();
        for(int i = size - 1; i > 0; i --) {
            int swapIndex = random.nextInt(i);
            swapTrainee(toShuffle, i , swapIndex);
        }

        return toShuffle;
    }
    public List<Group> getGroupList() throws JsonProcessingException {

        List<Group> groupList = new ArrayList<>(groupCount);
        for (int i = 0; i < 6; i++) {
            groupList.add(new Group());
        }
        List<Trainee> shuffledTrainee = shuffleList();
        for (int i = 0; i < shuffledTrainee.size(); i++) {
            groupList.get(i % groupCount).getTraineeList().add(shuffledTrainee.get(i));
        }
        return groupList;
    }
}
