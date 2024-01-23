package com.example.VaccinationBookingSystem.dto.requestdto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class BookAppointmentRequestDto {

    int personId;
    int doctorId;
}
