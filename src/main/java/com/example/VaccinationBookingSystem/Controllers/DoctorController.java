package com.example.VaccinationBookingSystem.Controllers;

import com.example.VaccinationBookingSystem.Service.DoctorService;
import com.example.VaccinationBookingSystem.dto.requestdto.DoctorRequestDto;
import com.example.VaccinationBookingSystem.dto.responsedto.DoctorResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/adddoctor")
    public ResponseEntity adddoctor(@RequestBody DoctorRequestDto doctorRequestDto){
        try{
            DoctorResponseDto ans = doctorService.adddoctor(doctorRequestDto);
            return new ResponseEntity(ans , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
}
