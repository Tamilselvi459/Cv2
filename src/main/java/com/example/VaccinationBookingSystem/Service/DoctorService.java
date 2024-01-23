package com.example.VaccinationBookingSystem.Service;

import com.example.VaccinationBookingSystem.Models.Doctor;
import com.example.VaccinationBookingSystem.Models.VaccinationCenter;
import com.example.VaccinationBookingSystem.Repository.DoctorRepository;
import com.example.VaccinationBookingSystem.Repository.VaccinationRepository;
import com.example.VaccinationBookingSystem.dto.requestdto.DoctorRequestDto;
import com.example.VaccinationBookingSystem.dto.responsedto.CenterResponseDto;
import com.example.VaccinationBookingSystem.dto.responsedto.DoctorResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    VaccinationRepository vaccinationRepository;
    public DoctorResponseDto adddoctor(DoctorRequestDto doctorRequestDto) throws ClassNotFoundException {


        Optional<VaccinationCenter> optcenter = vaccinationRepository.findById(doctorRequestDto.getCenterId());
        if(optcenter.isEmpty()){
            throw new ClassNotFoundException("Center Not found");
        }
        VaccinationCenter vc = optcenter.get();


        Doctor doctor = new Doctor();
        doctor.setAge(doctorRequestDto.getAge());
        doctor.setName(doctorRequestDto.getName());
        doctor.setEmailId(doctorRequestDto.getEmailId());
        doctor.setGender(doctorRequestDto.getGender());
        doctor.setCenter(vc);
        doctorRepository.save(doctor);
        vc.getDoctorList().add(doctor);
        VaccinationCenter svaccinationcenter = vaccinationRepository.save(vc);

        List<Doctor> list = svaccinationcenter.getDoctorList();
        Doctor lastsaved = list.get(list.size()-1);

        DoctorResponseDto doctorResponseDto = new DoctorResponseDto();
        doctorResponseDto.setName(lastsaved.getName());
        doctorResponseDto.setMessage("you have registered successfully");


        CenterResponseDto centerresponse = new CenterResponseDto();
        centerresponse.setCenterName(svaccinationcenter.getCenterName());
        centerresponse.setCenterType(svaccinationcenter.getCenterType());
        centerresponse.setAddress(svaccinationcenter.getAddress());

        doctorResponseDto.setCenterResponseDto(centerresponse);
        return doctorResponseDto;





    }
}
