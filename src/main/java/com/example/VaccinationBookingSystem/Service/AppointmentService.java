package com.example.VaccinationBookingSystem.Service;

import com.example.VaccinationBookingSystem.Exception.DoctorDoesNotExistException;
import com.example.VaccinationBookingSystem.Exception.PersonNotFoundException;
import com.example.VaccinationBookingSystem.Models.Appointment;
import com.example.VaccinationBookingSystem.Models.Doctor;
import com.example.VaccinationBookingSystem.Models.Person;
import com.example.VaccinationBookingSystem.Models.VaccinationCenter;
import com.example.VaccinationBookingSystem.Repository.AppointmentRepository;
import com.example.VaccinationBookingSystem.Repository.DoctorRepository;
import com.example.VaccinationBookingSystem.Repository.PersonRepository;
import com.example.VaccinationBookingSystem.dto.requestdto.BookAppointmentRequestDto;
import com.example.VaccinationBookingSystem.dto.responsedto.BookAppointmentResponseDto;
import com.example.VaccinationBookingSystem.dto.responsedto.CenterResponseDto;
import com.example.VaccinationBookingSystem.dto.responsedto.DoctorResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    JavaMailSender javaMailSender;

    public BookAppointmentResponseDto addappointment(BookAppointmentRequestDto bookAppointmentRequestDto) {

        Optional<Person> personOptional = personRepository.findById(bookAppointmentRequestDto.getPersonId());
        if(personOptional.isEmpty()){
            throw new PersonNotFoundException("Person does not exists");
        }

        Optional<Doctor> doctorOptional = doctorRepository.findById(bookAppointmentRequestDto.getDoctorId());
        if(doctorOptional.isEmpty()){
            throw new DoctorDoesNotExistException("Doctor does not exists");
        }
        Doctor doctor = doctorOptional.get();
        Person person = personOptional.get();

        Appointment appointment = new Appointment();
        appointment.setAppointmentId(String.valueOf(UUID.randomUUID()));
        appointment.setDoctor(doctor);
        appointment.setPerson(person);

        Appointment savedapp = appointmentRepository.save(appointment);
        person.getAppointmentList().add(savedapp);
        doctor.getAppointmentList().add(savedapp);

      Person savedperson =   personRepository.save(person);
      Doctor saveddoctor = doctorRepository.save(doctor);

      String text = savedperson.getName()+" have  booked the appointment successfully with the center"+saveddoctor.getCenter().getCenterName()+" in the date of"+appointment.getAppointmentDate()+"  Thank you";

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("projectwork243@gmail.com");
        simpleMailMessage.setTo(savedperson.getEmailId());
        simpleMailMessage.setSubject("Congrats !! appointment booked successfully");
        simpleMailMessage.setText(text);

        javaMailSender.send(simpleMailMessage);

       BookAppointmentResponseDto bookAppointmentResponseDto = new BookAppointmentResponseDto();
       bookAppointmentResponseDto.setDoctorname(saveddoctor.getName());
       bookAppointmentResponseDto.setPersonname(savedperson.getName());
       bookAppointmentResponseDto.setAppointmentdate(savedapp.getAppointmentDate());
       bookAppointmentResponseDto.setAppointmetId(savedapp.getAppointmentId());

        VaccinationCenter center = saveddoctor.getCenter();

        CenterResponseDto centerResponseDto = new CenterResponseDto();
        centerResponseDto.setCenterType(center.getCenterType());
        centerResponseDto.setCenterName(center.getCenterName());
        centerResponseDto.setAddress(center.getAddress());

        bookAppointmentResponseDto.setCenterResponseDto(centerResponseDto);
        return bookAppointmentResponseDto;
    }
}
