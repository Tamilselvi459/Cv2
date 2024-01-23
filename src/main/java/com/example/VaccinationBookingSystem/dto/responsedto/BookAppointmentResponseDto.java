package com.example.VaccinationBookingSystem.dto.responsedto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class BookAppointmentResponseDto {


    String doctorname;
    String personname;
    String appointmetId;
    Date appointmentdate;
    CenterResponseDto centerResponseDto;
}
