package com.example.VaccinationBookingSystem.Controllers;

import com.example.VaccinationBookingSystem.Models.Person;
import com.example.VaccinationBookingSystem.Service.PersonService;
import com.example.VaccinationBookingSystem.dto.requestdto.AddPersonRequestDto;
import com.example.VaccinationBookingSystem.dto.responsedto.AddPersonRepsonseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping("/add")
    public ResponseEntity addPerson(@RequestBody AddPersonRequestDto addPersonRequestDto){
        try{
            AddPersonRepsonseDto person1 = personService.addPerson(addPersonRequestDto);
            return new ResponseEntity(person1 , HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity("Email alreay exists" , HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update")
    public ResponseEntity updateEmail(@RequestParam("oldEmail") String oldEmail , @RequestParam("newEmail") String newEmail){
        try{
            String ans = personService.updateEmail(oldEmail , newEmail);
            return new ResponseEntity(ans , HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity( e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
