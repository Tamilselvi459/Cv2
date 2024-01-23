package com.example.VaccinationBookingSystem.dto.responsedto;

import com.example.VaccinationBookingSystem.Enum.CenterType;
import lombok.*;
import lombok.experimental.FieldDefaults;


@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class CenterResponseDto {

    CenterType centerType;

    String address;

    String centerName;

}
