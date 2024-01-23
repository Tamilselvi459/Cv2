package com.example.VaccinationBookingSystem.Controllers;

import com.example.VaccinationBookingSystem.Service.AppointmentService;
import com.example.VaccinationBookingSystem.dto.requestdto.BookAppointmentRequestDto;
import com.example.VaccinationBookingSystem.dto.responsedto.BookAppointmentResponseDto;
import com.example.VaccinationBookingSystem.dto.responsedto.BookDose1ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/addappointment")
    public ResponseEntity addappointment(@RequestBody BookAppointmentRequestDto bookAppointmentRequestDto){
      try{
          BookAppointmentResponseDto bookAppointmentResponseDto = appointmentService.addappointment(bookAppointmentRequestDto);
          return new ResponseEntity(bookAppointmentResponseDto , HttpStatus.OK);
      }catch(Exception ex){
          return new ResponseEntity<>(ex.getMessage() , HttpStatus.BAD_REQUEST);
      }
    }


}
