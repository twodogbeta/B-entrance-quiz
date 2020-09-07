package com.thoughtworks.capability.gtb.entrancequiz.domin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Group {
    private List<Trainee> traineeList = new ArrayList<>();

}
