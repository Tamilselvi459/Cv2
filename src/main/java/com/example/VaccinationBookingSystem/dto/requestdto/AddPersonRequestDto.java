package com.example.VaccinationBookingSystem.dto.requestdto;

import com.example.VaccinationBookingSystem.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class AddPersonRequestDto {

    String name;
    int age ;
    String emailId;
    Gender gender;
}


