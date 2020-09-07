package com.thoughtworks.capability.gtb.entrancequiz.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddNewTraineeRequestDto {
    String name;
}