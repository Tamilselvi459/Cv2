package com.example.VaccinationBookingSystem.Service;

import com.example.VaccinationBookingSystem.Exception.EmailDoesNotExists;
import com.example.VaccinationBookingSystem.Models.Person;
import com.example.VaccinationBookingSystem.Repository.PersonRepository;
import com.example.VaccinationBookingSystem.dto.requestdto.AddPersonRequestDto;
import com.example.VaccinationBookingSystem.dto.responsedto.AddPersonRepsonseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public AddPersonRepsonseDto addPerson(AddPersonRequestDto addPersonRequestDto) {


//        person.setDose1Taken(false);
//        person.setDose2Taken(false);
       Person person = new Person();
       person.setAge(addPersonRequestDto.getAge());
       person.setEmailId(addPersonRequestDto.getEmailId());
       person.setName(addPersonRequestDto.getName());
       person.setGender(addPersonRequestDto.getGender());
        Person ans =  personRepository.save(person);

        AddPersonRepsonseDto addPersonRepsonseDto = new AddPersonRepsonseDto();
        addPersonRepsonseDto.setName(ans.getName());
        addPersonRepsonseDto.setMessage("Congrats you have been registered successfully");
        return addPersonRepsonseDto;
    }

    public String updateEmail(String oldEmail, String newEmail) {

        Person person = personRepository.findByEmailId(oldEmail);
        if(person==null) throw new EmailDoesNotExists("old email does not exists");

      //  Person person1 = new Person();
        person.setEmailId(newEmail);
        personRepository.save(person);
        return "New email update successfully";
    }
}
