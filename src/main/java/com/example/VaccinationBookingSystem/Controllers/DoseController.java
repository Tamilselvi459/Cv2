package com.example.VaccinationBookingSystem.Controllers;

import com.example.VaccinationBookingSystem.Enum.DoseType;
import com.example.VaccinationBookingSystem.Models.Dose;
import com.example.VaccinationBookingSystem.Service.DoseService;
import com.example.VaccinationBookingSystem.dto.requestdto.BookDose1RequestDto;
import com.example.VaccinationBookingSystem.dto.responsedto.BookDose1ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dose")
public class DoseController {

    @Autowired
    DoseService doseService;

   @PostMapping("/adddose1")
    public ResponseEntity addDose1(@RequestBody BookDose1RequestDto bookDose1RequestDto){
      try{
           BookDose1ResponseDto bookDose1ResponseDto =   doseService.addDose1(bookDose1RequestDto);
          return new ResponseEntity(bookDose1ResponseDto , HttpStatus.OK);
      }catch(Exception ex){
          return new ResponseEntity(ex.getMessage() , HttpStatus.BAD_REQUEST);
      }
   }

}
