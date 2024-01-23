package com.example.VaccinationBookingSystem.dto.responsedto;

import com.example.VaccinationBookingSystem.Enum.DoseType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class BookDose1ResponseDto {

    int personId;
    DoseType doseType;
    String message;
}
