package com.example.VaccinationBookingSystem.Service;

import com.example.VaccinationBookingSystem.Enum.DoseType;
import com.example.VaccinationBookingSystem.Exception.DoseAlreadyTakenException;
import com.example.VaccinationBookingSystem.Exception.PersonNotFoundException;
import com.example.VaccinationBookingSystem.Models.Dose;
import com.example.VaccinationBookingSystem.Models.Person;
import com.example.VaccinationBookingSystem.Repository.DoseRepository;
import com.example.VaccinationBookingSystem.Repository.PersonRepository;
import com.example.VaccinationBookingSystem.dto.requestdto.BookDose1RequestDto;
import com.example.VaccinationBookingSystem.dto.responsedto.BookDose1ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {
    @Autowired
    DoseRepository doseRepository;

    @Autowired
    PersonRepository personRepository;
    public BookDose1ResponseDto addDose1(BookDose1RequestDto bookDose1RequestDto) {
        Optional<Person> person = personRepository.findById(bookDose1RequestDto.getPersonId());
        if(person.isEmpty()){
            throw new PersonNotFoundException("Invalid personId");
        }
        Person ans = person.get();
        if(ans.isDose1Taken()){
            throw new DoseAlreadyTakenException("Dose Already taken");
        }
        Dose dose = new Dose();
        dose.setDoseId(String.valueOf(UUID.randomUUID()));
        dose.setDosetype(bookDose1RequestDto.getDoseType());
        dose.setPerson(ans);
        ans.setDose1Taken(true);
        ans.getDosetaken().add(dose);
        doseRepository.save(dose);
        personRepository.save(ans);

        BookDose1ResponseDto bookDose1ResponseDto = new BookDose1ResponseDto();
        bookDose1ResponseDto.setDoseType(dose.getDosetype());
        bookDose1ResponseDto.setPersonId(dose.getPerson().getId());
        bookDose1ResponseDto.setMessage(dose.getPerson().getId() +" dose 1 given successfully");

        return bookDose1ResponseDto;
    }
}
