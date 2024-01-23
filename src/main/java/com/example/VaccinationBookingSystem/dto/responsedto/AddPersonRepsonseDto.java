package com.example.VaccinationBookingSystem.dto.responsedto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class AddPersonRepsonseDto {
    String name;
    String message;
}
