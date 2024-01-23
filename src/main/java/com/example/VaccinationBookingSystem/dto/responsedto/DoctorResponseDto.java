package com.example.VaccinationBookingSystem.dto.responsedto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class DoctorResponseDto {

    String name;
    String message;
    CenterResponseDto centerResponseDto;
}
