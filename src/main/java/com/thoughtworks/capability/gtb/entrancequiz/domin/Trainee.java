package com.thoughtworks.capability.gtb.entrancequiz.domin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Trainee {
    private int id;
    private String name;
}
