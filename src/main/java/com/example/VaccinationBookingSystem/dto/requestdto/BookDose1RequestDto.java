package com.example.VaccinationBookingSystem.dto.requestdto;

import com.example.VaccinationBookingSystem.Enum.DoseType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class BookDose1RequestDto {

    int personId;
    DoseType doseType;
}
