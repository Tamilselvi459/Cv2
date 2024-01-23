package com.example.VaccinationBookingSystem.Controllers;

import com.example.VaccinationBookingSystem.Service.VaccinationService;
import com.example.VaccinationBookingSystem.dto.requestdto.CenterRequestdto;
import com.example.VaccinationBookingSystem.dto.responsedto.CenterResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/center")
public class VaccinationController {
    @Autowired
    VaccinationService vaccinationService;

    @PostMapping("/addcenter")
    public ResponseEntity addcenter(@RequestBody CenterRequestdto centerRequestdto){
        CenterResponseDto ans = vaccinationService.addcenter(centerRequestdto);
        return new ResponseEntity(ans , HttpStatus.OK);
    }
}
